package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.entity.dom.DomRentAssembler;
import kz.maks.realestate.parser.assemblers.getDto.dom.DomRentGetDtoAssembler;
import kz.maks.realestate.parser.assemblers.listDto.dom.DomRentListDtoAssembler;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.parser.services.DomRentService;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomRentServiceImpl extends AbstractServiceImpl implements DomRentService {

    @Inject
    private DomRentAssembler domRentAssembler;

    @Inject
    private DomRentListDtoAssembler domRentDTOAssembler;

    @Inject
    private DomRentGetDtoAssembler domRentDetailsAssembler;

    @Override
    public ListResponse<DomRentListDto> list(DomRentSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPagination(listCriteria, rowCount, params.getPageSize(), params.getPage());

        List<DomRent> entityList = listCriteria.list();
        List<DomRentListDto> dtoList = new ArrayList<>();

        for (DomRent entity : entityList) {
            DomRentListDto dto = domRentDTOAssembler.assemble(entity, new DomRentListDto());
            dtoList.add(dto);
        }

        ListResponse<DomRentListDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(DomRentSearchParams params) {
        Criteria criteria = session().createCriteria(DomRent.class);

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
    public DomRentGetDto get(Long id) {
        DomRent entity = db.load(DomRent.class, id);
        DomRentGetDto details = domRentDetailsAssembler.assemble(entity, new DomRentGetDto());
        return details;
    }

    @Override
    public void save(DomRentGetDto dto) {
        DomRent entity = domRentAssembler.assemble(dto, new DomRent());
        db.save(entity);
    }

    @Override
    public void delete(Long id) {
        db.delete(DomRent.class, id);
    }

}
