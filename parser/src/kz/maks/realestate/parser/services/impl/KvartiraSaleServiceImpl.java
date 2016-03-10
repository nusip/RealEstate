package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.BackUtils;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.assemblers.getDto.kvartira.KvartiraSaleGetDtoAssembler;
import kz.maks.realestate.parser.assemblers.listDto.kvartira.KvartiraSaleListDtoAssembler;
import kz.maks.realestate.parser.assemblers.entity.kvartira.KvartiraSaleAssembler;
import kz.maks.realestate.parser.assemblers.parser.KvartiraSaleEntityAssembler;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.parser.models.KvartiraPlain;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;
import kz.maks.realestate.parser.services.KvartiraSaleService;
import kz.maks.realestate.shared.models.YesNo;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static kz.maks.core.shared.Utils.beginningOfDay;
import static kz.maks.core.shared.Utils.endOfDay;
import static kz.maks.core.shared.Utils.isNullOrZero;
import static org.hibernate.criterion.Projections.max;
import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.ge;
import static org.hibernate.criterion.Restrictions.isNotNull;

@Service
public class KvartiraSaleServiceImpl extends AbstractServiceImpl implements KvartiraSaleService {

    @Inject
    private KvartiraSaleAssembler kvartiraSaleAssembler;

    @Inject
    private KvartiraSaleListDtoAssembler kvartiraSaleDTOAssembler;

    @Inject
    private KvartiraSaleGetDtoAssembler kvartiraSaleDetailsAssembler;

    @Inject
    private KvartiraSaleEntityAssembler kvartiraSaleEntityAssembler;

    @Override
    public ListResponse<KvartiraSaleListDto> list(KvartiraSaleSearchParams params) {
        long rowCount = BackUtils.getRowCount(listCriteria(params));
        Criteria listCriteria = listCriteria(params);
        boolean hasNext = BackUtils.setPagination(listCriteria, rowCount, params.getPageSize(), params.getPage());

        List<KvartiraSale> entityList = listCriteria.list();
        List<KvartiraSaleListDto> dtoList = new ArrayList<>();

        for (KvartiraSale entity : entityList) {
            KvartiraSaleListDto dto = kvartiraSaleDTOAssembler.assemble(entity, new KvartiraSaleListDto());
            dtoList.add(dto);
        }

        ListResponse<KvartiraSaleListDto> listResponse = new ListResponse<>(dtoList, hasNext);

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
                criteria.add(Restrictions.eq("isObwyaga", true));

            } else if (params.getObwyaga() == YesNo.NO) {
                criteria.add(Restrictions.ne("isObwyaga", true));
            }
        }
        return criteria;
    }

    @Override
    public KvartiraSaleGetDto get(Long id) {
        KvartiraSale entity = db.load(KvartiraSale.class, id);
        KvartiraSaleGetDto details = kvartiraSaleDetailsAssembler.assemble(entity, new KvartiraSaleGetDto());
        return details;
    }

    @Override
    public void save(KvartiraSaleGetDto dto) {
        KvartiraSale kvartiraSale = null;

        if (dto.getId() == null && dto.getKrishaId() != null) {
            kvartiraSale = getByKrishaId(dto.getKrishaId());

            if (kvartiraSale != null)
                dto.setId(kvartiraSale.getId());
        }

        if (kvartiraSale == null) {
            kvartiraSale = new KvartiraSale();
            kvartiraSale.setCreatedAt(new Date());
        }

        kvartiraSale.setUpdatedAt(new Date().getTime());

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
            entity.setCreatedAt(new Date());
        }

        entity.setUpdatedAt(new Date().getTime());

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
    public Long getMaxUpdatedAt() {
        Long maxUpdatedAt = (Long) session().createCriteria(KvartiraSale.class).add(isNotNull("updatedAt"))
                .setProjection(max("updatedAt")).uniqueResult();
        return maxUpdatedAt;
    }

    @Override
    public List<KvartiraSaleGetDto> listNew(Long lastUpdatedAt) {
        Long now = new Date().getTime();

        if (lastUpdatedAt == null || (now - lastUpdatedAt) / Utils.ONE_DAY > 3) {
            lastUpdatedAt = now - Utils.ONE_DAY * 3;
        }

        List<KvartiraSale> list = session().createCriteria(KvartiraSale.class).add(ge("updatedAt", lastUpdatedAt)).list();
        List<KvartiraSaleGetDto> dtoList = new ArrayList<>();

        for (KvartiraSale kvartiraSale : list) {
            KvartiraSaleGetDto dto = kvartiraSaleDetailsAssembler.assemble(kvartiraSale, new KvartiraSaleGetDto());
            dtoList.add(dto);
        }

        return dtoList;
    }

}
