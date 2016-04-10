package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Service;
import kz.maks.core.back.services.impl.AbstractServiceImpl;
import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.parser.assemblers.dto.RefDtoAssembler;
import kz.maks.realestate.parser.entities.refs.AbstractRefEntity;
import kz.maks.realestate.parser.models.RefToEntity;
import kz.maks.realestate.parser.services.RefService;
import kz.maks.realestate.shared.refs.Ref;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

@Service
public class RefServiceImpl extends AbstractServiceImpl implements RefService {

    @Inject
    private RefDtoAssembler refDtoAssembler;

    @Override
    public List<RefDto> list(Ref ref) {
        RefToEntity refToEntity = RefToEntity.valueOf(ref.name());
        List<AbstractRefEntity> refEntityList = session().createCriteria(refToEntity.entityClass).list();
        List<RefDto> refDtoList = new ArrayList<>();

        for (AbstractRefEntity refEntity : refEntityList) {
            RefDto refDto = refDtoAssembler.assemble(refEntity, new RefDto());
            refDtoList.add(refDto);
        }

        return refDtoList;
    }

    @Override
    public void save(Ref ref, List<RefDto> dtos) {
        RefToEntity refToEntity = RefToEntity.valueOf(ref.name());

        for (RefDto refDto : dtos) {
            AbstractRefEntity refEntity = (AbstractRefEntity) session().createCriteria(refToEntity.entityClass)
                    .add(Restrictions.eq("code", refDto.getCode())).uniqueResult();
            refEntity.setTitle(refDto.getTitle());
        }
    }

}
