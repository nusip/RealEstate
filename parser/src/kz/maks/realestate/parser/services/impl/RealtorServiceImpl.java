package kz.maks.realestate.parser.services.impl;

import com.google.common.base.Strings;
import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.dto.realtor.RealtorDtoAssembler;
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
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

@Service
public class RealtorServiceImpl extends AbstractServiceImpl implements RealtorService {

    @Inject
    private RealtorDtoAssembler realtorDtoAssembler;

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

}
