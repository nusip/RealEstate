package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.dto.realtor.RealtorDtoAssembler;
import kz.maks.realestate.parser.assemblers.entity.realtor.RealtorAssembler;
import kz.maks.realestate.parser.entities.Realtor;
import kz.maks.realestate.parser.services.RealtorService;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.BasicType;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Calendar.DAY_OF_YEAR;
import static kz.maks.core.shared.Utils.getDateDifference;
import static org.hibernate.criterion.Projections.max;
import static org.hibernate.criterion.Restrictions.*;

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
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

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
            criteria.add(ilike("name", params.getName(), MatchMode.ANYWHERE));
        }
        if (!isNullOrEmpty(params.getCompany())) {
            criteria.add(ilike("company", params.getCompany(), MatchMode.ANYWHERE));
        }

        if (!isNullOrEmpty(params.getTelNumber())) {
            String telNumber = "%" + params.getTelNumber().replaceAll("\\D+", "") + "%";

            BasicType basicType = session().getTypeHelper().basic(String.class);

            Criteria telNumbersCri = criteria.createCriteria("telNumbers");
            telNumbersCri.add(sqlRestriction("regexp_replace({alias}.telNumbers, '\\D+', '', 'g') like ?", telNumber, basicType));
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

    @Override
    public List<String> listRealtorsNumbers(List<String> phoneNumbers) {
        List<String> realtorsNumbers = new ArrayList<>();

        for (String phoneNumber : phoneNumbers) {
            if (isRealtorNumber(phoneNumber))
                realtorsNumbers.add(phoneNumber);
        }

        return realtorsNumbers;
    }

    private boolean isRealtorNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\D+", "");

        BasicType basicType = session().getTypeHelper().basic(String.class);

        Criteria criteria = session().createCriteria(Realtor.class);
        Criteria telNumbersCri = criteria.createCriteria("telNumbers");

        telNumbersCri.add(sqlRestriction("regexp_replace({alias}.telNumbers, '\\D+', '', 'g') = ?", phoneNumber, basicType));

        List results = criteria.list();
        return !results.isEmpty();
    }

}
