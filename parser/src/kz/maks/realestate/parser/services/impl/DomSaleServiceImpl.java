package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.entity.dom.DomSaleAssembler;
import kz.maks.realestate.parser.assemblers.dto.dom.DomSaleDtoAssembler;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.parser.services.DomSaleService;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomSaleServiceImpl extends AbstractServiceImpl implements DomSaleService {

    @Inject
    private DomSaleAssembler domSaleAssembler;

    @Inject
    private DomSaleDtoAssembler domSaleDTOAssembler;

    @Inject
    private DomSaleDtoAssembler domSaleDetailsAssembler;

    @Override
    public ListResponse<DomSaleDto> list(DomSaleSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPagination(listCriteria, rowCount, params.getPageSize(), params.getPage());

        List<DomSale> entityList = listCriteria.list();
        List<DomSaleDto> dtoList = new ArrayList<>();

        for (DomSale entity : entityList) {
            DomSaleDto dto = domSaleDTOAssembler.assemble(entity, new DomSaleDto());
            dtoList.add(dto);
        }

        ListResponse<DomSaleDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(DomSaleSearchParams params) {
        Criteria criteria = session().createCriteria(DomSale.class);

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
    public DomSaleDto get(Long id) {
        DomSale entity = db.load(DomSale.class, id);
        DomSaleDto details = domSaleDetailsAssembler.assemble(entity, new DomSaleDto());
        return details;
    }

    @Override
    public void save(DomSaleDto dto) {
        DomSale entity = domSaleAssembler.assemble(dto, new DomSale());
        db.save(entity);
    }

    @Override
    public void delete(Long id) {
        db.delete(DomSale.class, id);
    }

}
