package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.entity.kvartira.KvartiraRentAssembler;
import kz.maks.realestate.parser.assemblers.dto.kvartira.KvartiraRentDtoAssembler;
import kz.maks.realestate.parser.assemblers.parser.KvartiraRentEntityAssembler;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.parser.services.KvartiraRentService;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;
import kz.maks.realestate.parser.models.KvartiraPlain;
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

@Service
public class KvartiraRentServiceImpl extends AbstractServiceImpl implements KvartiraRentService {

    @Inject
    private KvartiraRentAssembler kvartiraRentAssembler;

    @Inject
    private KvartiraRentEntityAssembler kvartiraRentEntityAssemblerPlain;

    @Inject
    private KvartiraRentDtoAssembler kvartiraRentDTOAssembler;

    @Inject
    private KvartiraRentDtoAssembler kvartiraRentDetailsAssembler;

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
    public ListResponse<KvartiraRentDto> list(KvartiraRentSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

        List<KvartiraRent> entityList = listCriteria.list();
        List<KvartiraRentDto> dtoList = new ArrayList<>();

        for (KvartiraRent entity : entityList) {
            KvartiraRentDto dto = kvartiraRentDTOAssembler.assemble(entity, new KvartiraRentDto());
            dtoList.add(dto);
        }

        ListResponse<KvartiraRentDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(KvartiraRentSearchParams params) {
        Criteria criteria = session().createCriteria(KvartiraRent.class);

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
        if (params.getRooms() != null) {
            if (params.getRooms().min() != null) {
                criteria.add(Restrictions.ge("kolichestvoKomnat", params.getRooms().min()));
            }
            if (params.getRooms().max() != null) {
                criteria.add(Restrictions.le("kolichestvoKomnat", params.getRooms().max()));
            }
        }
        if (!isNullOrZero(params.getEtazhMin())) {
            criteria.add(Restrictions.ge("etazh", params.getEtazhMin()));
        }
        if (!isNullOrZero(params.getEtazhMax())) {
            criteria.add(Restrictions.le("etazh", params.getEtazhMax()));
        }
        if (!isNullOrZero(params.getEtazhnostMin())) {
            criteria.add(Restrictions.ge("etazhnost", params.getEtazhnostMin()));
        }
        if (!isNullOrZero(params.getEtazhnostMax())) {
            criteria.add(Restrictions.le("etazhnost", params.getEtazhnostMax()));
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
        if (params.getObwyaga() != null && params.getObwyaga() != YesNo.NO_MATTER) {
            if (params.getObwyaga() == YesNo.YES) {
                criteria.add(Restrictions.eq("isObwyaga", true));

            } else if (params.getObwyaga() == YesNo.NO) {
                criteria.add(Restrictions.ne("isObwyaga", true));
            }
        }
        return criteria;
    }

    @Override
    public KvartiraRentDto get(Long id) {
        KvartiraRent entity = db.load(KvartiraRent.class, id);
        KvartiraRentDto details = kvartiraRentDetailsAssembler.assemble(entity, new KvartiraRentDto());
        return details;
    }

    @Override
    public void save(KvartiraRentDto dto) {
        KvartiraRent kvartiraRent = null;

        if (dto.getId() == null && dto.getKrishaId() != null) {
            kvartiraRent = getByKrishaId(dto.getKrishaId());

            if (kvartiraRent != null)
                dto.setId(kvartiraRent.getId());
        }

        if (kvartiraRent == null) {
            kvartiraRent = new KvartiraRent();
            kvartiraRent.setCreatedAt(new Date());
        }

        kvartiraRent.setUpdatedAt(new Date());

        KvartiraRent entity = kvartiraRentAssembler.assemble(dto, kvartiraRent);

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

    @Override
    public List<KvartiraRentDto> listHistory(Long id) {
        AuditReader reader = AuditReaderFactory.get(session());
        List<KvartiraRent> revisions = reader.createQuery().forRevisionsOfEntity(KvartiraRent.class, true, true)
                .add(AuditEntity.id().eq(id)).getResultList();

        List<KvartiraRentDto> revisionDtoList = new ArrayList<>();

        for (KvartiraRent rev : revisions) {
            KvartiraRentDto revDto = kvartiraRentDTOAssembler.assemble(rev, new KvartiraRentDto());
            revisionDtoList.add(revDto);
        }

        return revisionDtoList;
    }

}
