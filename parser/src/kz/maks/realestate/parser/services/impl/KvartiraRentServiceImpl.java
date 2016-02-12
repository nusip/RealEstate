package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.entity.kvartira.KvartiraRentAssembler;
import kz.maks.realestate.parser.assemblers.getDto.kvartira.KvartiraRentGetDtoAssembler;
import kz.maks.realestate.parser.assemblers.listDto.kvartira.KvartiraRentListDtoAssembler;
import kz.maks.realestate.parser.assemblers.parser.KvartiraRentEntityAssembler;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.parser.services.KvartiraRentService;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraRentListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;
import kz.maks.realestate.parser.models.KvartiraPlain;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

@Service
public class KvartiraRentServiceImpl extends AbstractServiceImpl implements KvartiraRentService {

    @Inject
    private KvartiraRentAssembler kvartiraRentAssembler;

    @Inject
    private KvartiraRentEntityAssembler kvartiraRentEntityAssemblerPlain;

    @Inject
    private KvartiraRentListDtoAssembler kvartiraRentDTOAssembler;

    @Inject
    private KvartiraRentGetDtoAssembler kvartiraRentDetailsAssembler;

    @Override
    public void save(KvartiraPlain kvartiraPlain) {
        KvartiraRent entity = kvartiraRentEntityAssemblerPlain.assemble(kvartiraPlain, new KvartiraRent());

        KvartiraRent existing = getByKrishaId(kvartiraPlain.getKrishaId());

        if (existing != null) {
            entity.setId(existing.getId());
        }

        db.save(entity);
    }

    private KvartiraRent getByKrishaId(String krishaId) {
        KvartiraRent kvartiraRent = (KvartiraRent) session().createCriteria(KvartiraRent.class)
                .add(Restrictions.eq("krishaId", krishaId)).uniqueResult();
        return kvartiraRent;
    }

    @Override
    public ListResponse<KvartiraRentListDto> list(KvartiraRentSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPagination(listCriteria, rowCount, params.getPageSize(), params.getPage());

        List<KvartiraRent> entityList = listCriteria.list();
        List<KvartiraRentListDto> dtoList = new ArrayList<>();

        for (KvartiraRent entity : entityList) {
            KvartiraRentListDto dto = kvartiraRentDTOAssembler.assemble(entity, new KvartiraRentListDto());
            dtoList.add(dto);
        }

        ListResponse<KvartiraRentListDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(KvartiraRentSearchParams params) {
        Criteria criteria = session().createCriteria(KvartiraRent.class);

        if (params.getRegionId() != null) {
            Criteria criRegion = criteria.createCriteria("region");
            criRegion.add(Restrictions.like("path", params.getRegionId() + "", MatchMode.ANYWHERE));
        }
        if (params.getRooms() != null) {
            if (params.getRooms().min() != null) {
                criteria.add(Restrictions.ge("kolichestvoKomnat", params.getRooms().min()));
            }
            if (params.getRooms().max() != null) {
                criteria.add(Restrictions.le("kolichestvoKomnat", params.getRooms().max()));
            }
        }
        return criteria;
    }

    @Override
    public KvartiraRentGetDto get(Long id) {
        KvartiraRent entity = db.load(KvartiraRent.class, id);
        KvartiraRentGetDto details = kvartiraRentDetailsAssembler.assemble(entity, new KvartiraRentGetDto());
        return details;
    }

    @Override
    public void save(KvartiraRentGetDto dto) {
        KvartiraRent entity = kvartiraRentAssembler.assemble(dto, new KvartiraRent());
        db.save(entity);
    }

    @Override
    public void delete(Long id) {
        db.delete(KvartiraRent.class, id);
    }

    @Override
    public boolean exists(String krishaId) {
        KvartiraRent kvartiraRent = getByKrishaId(krishaId);
        return kvartiraRent != null;
    }

}
