package kz.maks.realestate.parser.assemblers.dto;

import com.google.common.collect.Lists;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.entities.AbstractKrishaAdEntity;
import kz.maks.realestate.shared.dtos.AbstractKrishaAdDto;

import java.util.Date;

import static kz.maks.core.shared.Utils.extractId;

public abstract class AbstractKrishaAdDtoAssembler<ENTITY extends AbstractKrishaAdEntity, DTO extends AbstractKrishaAdDto>
        implements IAssembler<ENTITY, DTO> {

    @Override
    public DTO assemble(ENTITY entity, DTO dto) {
        dto.setId(entity.getId());
        dto.setKrishaId(entity.getKrishaId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt() != null ? new Date(entity.getUpdatedAt()) : null);
        dto.setCena(entity.getCena() != null ? entity.getCena().doubleValue() : null);
        dto.setCenaProdazhi(entity.getCenaProdazhi() != null ? entity.getCenaProdazhi().doubleValue() : null);
        dto.setValyutaId(extractId(entity.getValyuta()));
        dto.setValyuta(entity.getValyuta() != null ? entity.getValyuta().getTitle() : null);
        dto.setRegionId(extractId(entity.getRegion()));
        dto.setRegion(entity.getRegion() != null ? entity.getRegion().getName() : null);
        dto.setRegionKrishaId(entity.getRegion() != null ? entity.getRegion().getKrishaId() : null);
        dto.setUlica(entity.getUlica());
        dto.setPeresechenie(entity.getPeresechenie());
        dto.setDom(entity.getDom());
        dto.setRaznoe(entity.getRaznoe());
        dto.setPrimechanie(entity.getPrimechanie());
        dto.setTelNumbers(Lists.newArrayList(entity.getTelNumbers()));
        dto.setPhotoPaths(Lists.newArrayList(entity.getPhotoPaths()));
        dto.setIstochnikInfoId(extractId(entity.getIstochnikInfo()));
        dto.setIstochnikInfo(entity.getIstochnikInfo() != null ? entity.getIstochnikInfo().getTitle() : null);
        dto.setAssignedToId(Utils.extractId(entity.getAssignedTo()));
        dto.setAssignedTo(entity.getAssignedTo() != null ? entity.getAssignedTo().getFullName() : null);
        dto.setModifiedById(Utils.extractId(entity.getModifiedBy()));
        dto.setModifiedBy(entity.getModifiedBy() != null ? entity.getModifiedBy().getFullName() : null);
        dto.setIsArchive(entity.getIsArchive());
        return dto;
    }

}
