package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.entity.dom.DomSaleAssembler;
import kz.maks.realestate.parser.assemblers.dto.dom.DomSaleDtoAssembler;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.parser.services.DomSaleService;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;
import kz.maks.realestate.shared.models.YesNo;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static kz.maks.core.shared.Utils.beginningOfDay;
import static kz.maks.core.shared.Utils.endOfDay;
import static kz.maks.core.shared.Utils.isNullOrZero;
import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.isNull;
import static org.hibernate.criterion.Restrictions.or;

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
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

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

        if (params.getDataSozdaniyaFrom() != null) {
            criteria.add(Restrictions.ge("createdAt", beginningOfDay(params.getDataSozdaniyaFrom())));
        }
        if (params.getDataSozdaniyaTo() != null) {
            criteria.add(Restrictions.le("createdAt", endOfDay(params.getDataSozdaniyaTo())));
        }
        if (params.getRegionId() != null) {
            Criteria criRegion = criteria.createCriteria("region");
            criRegion.add(Restrictions.like("path", params.getRegionId() + "", MatchMode.ANYWHERE));
        }
        if (!isNullOrZero(params.getPloshadObshayaMin())) {
            criteria.add(Restrictions.ge("ploshadObshaya", params.getPloshadObshayaMin()));
        }
        if (!isNullOrZero(params.getPloshadObshayaMax())) {
            criteria.add(Restrictions.le("ploshadObshaya", params.getPloshadObshayaMax()));
        }
        if (!isNullOrZero(params.getPloshadKuhnyaMin())) {
            criteria.add(Restrictions.ge("ploshadKuhnya", params.getPloshadKuhnyaMin()));
        }
        if (!isNullOrZero(params.getPloshadKuhnyaMax())) {
            criteria.add(Restrictions.le("ploshadKuhnya", params.getPloshadKuhnyaMax()));
        }
        if (params.getRooms() != null) {
            if (params.getRooms().min() != null) {
                criteria.add(Restrictions.ge("kolichestvoKomnat", params.getRooms().min()));
            }
            if (params.getRooms().max() != null) {
                criteria.add(Restrictions.le("kolichestvoKomnat", params.getRooms().max()));
            }
        }
        if (params.getVArhive() != null && params.getVArhive() != YesNo.NO_MATTER) {
            if (params.getVArhive() == YesNo.YES) {
                criteria.add(eq("isArchive", true));

            } else if (params.getVArhive() == YesNo.NO) {
                criteria.add(or(isNull("isArchive"), eq("isArchive", false)));
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
        DomSale domSale = null;

        if (dto.getKrishaId() != null) {
            domSale = getByKrishaId(dto.getKrishaId());

        } else if (dto.getId() != null) {
            domSale = db.load(DomSale.class, dto.getId());

        } else {
            domSale = new DomSale();
            domSale.setCreatedAt(new Date());
        }

        domSale.setUpdatedAt(new Date());

        DomSale entity = domSaleAssembler.assemble(dto, domSale);

        db.save(entity);
    }

    private DomSale getByKrishaId(String krishaId) {
        DomSale domSale = (DomSale) session().createCriteria(DomSale.class)
                .add(eq("krishaId", krishaId)).uniqueResult();
        return domSale;
    }

    @Override
    public void delete(Long id) {
        db.delete(DomSale.class, id);
    }

    @Override
    public List<DomSaleDto> listHistory(Long id) {
        AuditReader reader = AuditReaderFactory.get(session());
        List<DomSale> revisions = reader.createQuery().forRevisionsOfEntity(DomSale.class, true, true)
                .add(AuditEntity.id().eq(id)).getResultList();

        List<DomSaleDto> revisionDtoList = new ArrayList<>();

        for (DomSale rev : revisions) {
            DomSaleDto revDto = domSaleDTOAssembler.assemble(rev, new DomSaleDto());
            revisionDtoList.add(revDto);
        }

        return revisionDtoList;
    }

}
