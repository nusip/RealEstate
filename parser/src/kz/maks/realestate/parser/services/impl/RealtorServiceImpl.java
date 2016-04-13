package kz.maks.realestate.parser.services.impl;

import com.google.common.base.Strings;
import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.dto.realtor.RealtorDtoAssembler;
import kz.maks.realestate.parser.assemblers.entity.RealtorAssembler;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.parser.entities.Realtor;
import kz.maks.realestate.parser.services.RealtorService;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.persister.collection.CollectionPropertyNames;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Calendar.DAY_OF_YEAR;
import static kz.maks.core.shared.Utils.getDateDifference;
import static org.hibernate.criterion.Projections.max;
import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.ge;
import static org.hibernate.criterion.Restrictions.isNotNull;

@Service
public class RealtorServiceImpl extends AbstractServiceImpl implements RealtorService {

    @Inject
    private RealtorDtoAssembler realtorDtoAssembler;

    @Inject
    private RealtorAssembler realtorAssembler;

    @Override
    public ListResponse<RealtorDto> list(RealtorSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPagination(listCriteria, rowCount, params.getPageSize(), params.getPage());

        List<Realtor> entityList = listCriteria.list();
        List<RealtorDto> dtoList = new ArrayList<>();

        for (Realtor entity : entityList) {
            RealtorDto dto = realtorDtoAssembler.assemble(entity, new RealtorDto());
            dtoList.add(dto);
        }

        ListResponse<RealtorDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(RealtorSearchParams params) {
        Criteria criteria = session().createCriteria(Realtor.class);

        if (!isNullOrEmpty(params.getName())) {
            criteria.add(Restrictions.ilike("name", params.getName(), MatchMode.ANYWHERE));
        }
        if (!isNullOrEmpty(params.getCompany())) {
            criteria.add(Restrictions.ilike("company", params.getCompany(), MatchMode.ANYWHERE));
        }
        if (!isNullOrEmpty(params.getTelNumber())) {
            Criteria telNumbersCri = criteria.createCriteria("telNumbers");
            telNumbersCri.add(Restrictions.ilike(CollectionPropertyNames.COLLECTION_ELEMENTS,
                    params.getTelNumber(), MatchMode.ANYWHERE));
        }

        return criteria;
    }

    @Override
    public Date getMaxUpdatedAt() {
        Date maxUpdatedAt = (Date) session().createCriteria(Realtor.class).add(isNotNull("updatedAt"))
                .setProjection(max("updatedAt")).uniqueResult();
        return maxUpdatedAt;
    }

    @Override
    public List<RealtorDto> listNew(Date lastUpdatedAt) {
        Date now = new Date();

        if (lastUpdatedAt == null || getDateDifference(now, lastUpdatedAt, TimeUnit.DAYS) > 3) {
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.add(DAY_OF_YEAR, -3);
            lastUpdatedAt = c.getTime();
        }

        List<Realtor> list = session().createCriteria(Realtor.class).add(ge("updatedAt", lastUpdatedAt)).list();
        List<RealtorDto> dtoList = new ArrayList<>();

        for (Realtor realtor : list) {
            RealtorDto dto = realtorDtoAssembler.assemble(realtor, new RealtorDto());
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public boolean realtorExists(String krishaId) {
        Realtor realtor = getByKrishaId(krishaId);
        return realtor != null;
    }

    private Realtor getByKrishaId(String krishaId) {
        Realtor realtor = (Realtor) session().createCriteria(Realtor.class)
                .add(eq("krishaId", krishaId)).uniqueResult();
        return realtor;
    }

    @Override
    public void save(RealtorDto dto) {
        Realtor realtor = null;

        if (dto.getId() == null && dto.getKrishaId() != null) {
            realtor = getByKrishaId(dto.getKrishaId());

            if (realtor != null)
                dto.setId(realtor.getId());
        }

        if (realtor == null) {
            realtor = new Realtor();
            realtor.setCreatedAt(new Date());
        }

        realtor.setUpdatedAt(new Date());

        Realtor entity = realtorAssembler.assemble(dto, realtor);

        db.save(entity);
    }

}