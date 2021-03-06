package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.dto.kvartira.KvartiraSaleDtoAssembler;
import kz.maks.realestate.parser.assemblers.entity.kvartira.KvartiraSaleAssembler;
import kz.maks.realestate.parser.assemblers.parser.KvartiraSaleEntityAssembler;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.parser.models.KvartiraPlain;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;
import kz.maks.realestate.parser.services.KvartiraSaleService;
import kz.maks.realestate.shared.models.YesNo;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Calendar.DAY_OF_YEAR;
import static kz.maks.core.shared.Utils.*;
import static org.hibernate.criterion.Projections.max;
import static org.hibernate.criterion.Restrictions.*;

@Service
public class KvartiraSaleServiceImpl extends AbstractServiceImpl implements KvartiraSaleService {

    @Inject
    private KvartiraSaleAssembler kvartiraSaleAssembler;

    @Inject
    private KvartiraSaleDtoAssembler kvartiraSaleDTOAssembler;

    @Inject
    private KvartiraSaleEntityAssembler kvartiraSaleEntityAssembler;

    @Override
    public ListResponse<KvartiraSaleDto> list(KvartiraSaleSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPaginationAndSorting(listCriteria, rowCount, params);

        List<KvartiraSale> entityList = listCriteria.list();
        List<KvartiraSaleDto> dtoList = new ArrayList<>();

        for (KvartiraSale entity : entityList) {
            KvartiraSaleDto dto = kvartiraSaleDTOAssembler.assemble(entity, new KvartiraSaleDto());
            dtoList.add(dto);
        }

        ListResponse<KvartiraSaleDto> listResponse = new ListResponse<>(dtoList, hasNext);

        return listResponse;
    }

    private Criteria listCriteria(KvartiraSaleSearchParams params) {
        Criteria criteria = session().createCriteria(KvartiraSale.class);

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
                criteria.add(eq("isObwyaga", true));

            } else if (params.getObwyaga() == YesNo.NO) {
                criteria.add(or(isNull("isObwyaga"), eq("isObwyaga", false)));
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
    public KvartiraSaleDto get(Long id) {
        KvartiraSale entity = db.load(KvartiraSale.class, id);
        KvartiraSaleDto details = kvartiraSaleDTOAssembler.assemble(entity, new KvartiraSaleDto());
        return details;
    }

    @Override
    public void save(KvartiraSaleDto dto) {
        KvartiraSale kvartiraSale = null;

        if (dto.getKrishaId() != null) {
            kvartiraSale = getByKrishaId(dto.getKrishaId());

        } else if (dto.getId() != null) {
            kvartiraSale = db.load(KvartiraSale.class, dto.getId());
        }

        if (kvartiraSale == null) {
            kvartiraSale = new KvartiraSale();
            kvartiraSale.setCreatedAt(new Date());
        }

        kvartiraSale.setUpdatedAt(new Date());

        KvartiraSale entity = kvartiraSaleAssembler.assemble(dto, kvartiraSale);

        db.save(entity);
    }

    @Override
    public void delete(Long id) {
        db.delete(KvartiraSale.class, id);
    }

    @Override
    public void saveKvartiraSale(KvartiraPlain kvartiraPlain) {
        KvartiraSale entity = kvartiraSaleEntityAssembler.assemble(kvartiraPlain, new KvartiraSale());

        KvartiraSale existing = getByKrishaId(kvartiraPlain.getKrishaId());

        if (existing != null) {
            entity.setId(existing.getId());
        } else {
            entity.setCreatedAt(new Date());
        }

        entity.setUpdatedAt(new Date());

        db.save(entity);
    }

    private KvartiraSale getByKrishaId(String krishaId) {
        KvartiraSale kvartiraSale = (KvartiraSale) session().createCriteria(KvartiraSale.class)
                .add(eq("krishaId", krishaId)).uniqueResult();
        return kvartiraSale;
    }

    @Override
    public boolean kvartiraSaleExists(String krishaId) {
        KvartiraSale kvartiraSale = getByKrishaId(krishaId);
        return kvartiraSale != null;
    }

    @Override
    public Date getMaxUpdatedAt() {
        Date maxUpdatedAt = (Date) session().createCriteria(KvartiraSale.class).add(isNotNull("updatedAt"))
                .setProjection(max("updatedAt")).uniqueResult();
        return maxUpdatedAt;
    }

    @Override
    public List<KvartiraSaleDto> listNew(Date lastUpdatedAt) {
        Date now = new Date();

        if (lastUpdatedAt == null || getDateDifference(now, lastUpdatedAt, TimeUnit.DAYS) > 3) {
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.add(DAY_OF_YEAR, -3);
            lastUpdatedAt = c.getTime();
        }

        List<KvartiraSale> list = session().createCriteria(KvartiraSale.class).add(ge("updatedAt", lastUpdatedAt)).list();
        List<KvartiraSaleDto> dtoList = new ArrayList<>();

        for (KvartiraSale kvartiraSale : list) {
            KvartiraSaleDto dto = kvartiraSaleDTOAssembler.assemble(kvartiraSale, new KvartiraSaleDto());
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<KvartiraSaleDto> listHistory(Long id) {
        AuditReader reader = AuditReaderFactory.get(session());
        List<KvartiraSale> revisions = reader.createQuery().forRevisionsOfEntity(KvartiraSale.class, true, true)
                .add(AuditEntity.id().eq(id)).getResultList();

        List<KvartiraSaleDto> revisionDtoList = new ArrayList<>();

        for (KvartiraSale rev : revisions) {
            KvartiraSaleDto revDto = kvartiraSaleDTOAssembler.assemble(rev, new KvartiraSaleDto());
            revisionDtoList.add(revDto);
        }

        return revisionDtoList;
    }

}
