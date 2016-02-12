package kz.maks.realestate.parser.assemblers.getDto;

import com.google.common.collect.Lists;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.AbstractKrishaAdEntity;
import kz.maks.realestate.shared.dtos.get.AbstractKrishaAdGetDto;

import java.util.Arrays;

import static kz.maks.core.shared.Utils.extractId;

public abstract class AbstractKrishaAdGetDtoAssembler<ENTITY extends AbstractKrishaAdEntity, DTO extends AbstractKrishaAdGetDto>
        implements IAssembler<ENTITY, DTO> {

    @Override
    public DTO assemble(ENTITY entity, DTO dto) {
        dto.setId(entity.getId());
        dto.setKrishaId(entity.getKrishaId());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setCena(entity.getCena() != null ? entity.getCena().doubleValue() : null);
        dto.setValyuta(entity.getValyuta());
        dto.setRegionId(extractId(entity.getRegion()));
        dto.setRegionKrishaId(entity.getRegion() != null ? entity.getRegion().getKrishaId() : null);
        dto.setUlicaDom(entity.getUlicaDom());
        dto.setRaznoe(entity.getRaznoe());
        dto.setTelNumbers(Lists.newArrayList(entity.getTelNumbers()));
        dto.setPhotoPaths(Lists.newArrayList(entity.getPhotoPaths()));
        return dto;
    }

}
