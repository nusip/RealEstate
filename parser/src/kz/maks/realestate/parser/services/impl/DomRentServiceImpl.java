package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.entity.dom.DomRentAssembler;
import kz.maks.realestate.parser.assemblers.dto.dom.DomRentDtoAssembler;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.parser.services.DomRentService;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;
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
public class DomRentServiceImpl extends AbstractServiceImpl implements DomRentService {

    @Inject
    private DomRentAssembler domRentAssembler;

    @Inject
    private DomRentDtoAssembler domRentDTOAssembler;

    @Inject
    private DomRentDtoAssembler domRentDetailsAssembler;

    @Override
    public ListResponse<DomRentDto> list(DomRentSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

        List<DomRent> entityList = listCriteria.list();
        List<DomRentDto> dtoList = new ArrayList<>();

        for (DomRent entity : entityList) {
            DomRentDto dto = domRentDTOAssembler.assemble(entity, new DomRentDto());
            dtoList.add(dto);
        }

        ListResponse<DomRentDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(DomRentSearchParams params) {
        Criteria criteria = session().createCriteria(DomRent.class);

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
    public DomRentDto get(Long id) {
        DomRent entity = db.load(DomRent.class, id);
        DomRentDto details = domRentDetailsAssembler.assemble(entity, new DomRentDto());
        return details;
    }

    @Override
    public void save(DomRentDto dto) {
        DomRent domRent = null;

        if (dto.getKrishaId() != null) {
            domRent = getByKrishaId(dto.getKrishaId());

        } else if (dto.getId() != null) {
            domRent = db.load(DomRent.class, dto.getId());

        } else {
            domRent = new DomRent();
            domRent.setCreatedAt(new Date());
        }

        domRent.setUpdatedAt(new Date());

        DomRent entity = domRentAssembler.assemble(dto, domRent);

        db.save(entity);
    }

    private DomRent getByKrishaId(String krishaId) {
        DomRent domRent = (DomRent) session().createCriteria(DomRent.class)
                .add(eq("krishaId", krishaId)).uniqueResult();
        return domRent;
    }

    @Override
    public void delete(Long id) {
        db.delete(DomRent.class, id);
    }

    @Override
    public List<DomRentDto> listHistory(Long id) {
        AuditReader reader = AuditReaderFactory.get(session());
        List<DomRent> revisions = reader.createQuery().forRevisionsOfEntity(DomRent.class, true, true)
                .add(AuditEntity.id().eq(id)).getResultList();

        List<DomRentDto> revisionDtoList = new ArrayList<>();

        for (DomRent rev : revisions) {
            DomRentDto revDto = domRentDTOAssembler.assemble(rev, new DomRentDto());
            revisionDtoList.add(revDto);
        }

        return revisionDtoList;
    }

}
