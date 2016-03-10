package kz.maks.realestate.parser.assemblers.getDto;

import com.google.common.collect.Lists;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.entities.AbstractKrishaAdEntity;
import kz.maks.realestate.shared.dtos.get.AbstractKrishaAdGetDto;

import java.util.Date;

import static kz.maks.core.shared.Utils.extractId;

public abstract class AbstractKrishaAdGetDtoAssembler<ENTITY extends AbstractKrishaAdEntity, DTO extends AbstractKrishaAdGetDto>
        implements IAssembler<ENTITY, DTO> {

    @Override
    public DTO assemble(ENTITY entity, DTO dto) {
        dto.setId(entity.getId());
        dto.setKrishaId(entity.getKrishaId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(new Date(entity.getUpdatedAt()));
        dto.setCena(entity.getCena() != null ? entity.getCena().doubleValue() : null);
        dto.setCenaProdazhi(entity.getCenaProdazhi() != null ? entity.getCenaProdazhi().doubleValue() : null);
        dto.setValyuta(entity.getValyuta());
        dto.setRegionId(extractId(entity.getRegion()));
        dto.setRegionKrishaId(entity.getRegion() != null ? entity.getRegion().getKrishaId() : null);
        dto.setUlica(entity.getUlica());
        dto.setPeresechenie(entity.getPeresechenie());
        dto.setDom(entity.getDom());
        dto.setRaznoe(entity.getRaznoe());
        dto.setPrimechanie(entity.getPrimechanie());
        dto.setTelNumbers(Lists.newArrayList(entity.getTelNumbers()));
        dto.setPhotoPaths(Lists.newArrayList(entity.getPhotoPaths()));
        dto.setIstochnikInfo(entity.getIstochnikInfo());
        dto.setAssignedToId(Utils.extractId(entity.getAssignedTo()));
        return dto;
    }

}
