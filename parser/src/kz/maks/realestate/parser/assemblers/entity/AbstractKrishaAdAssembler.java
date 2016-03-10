package kz.maks.realestate.parser.assemblers.entity;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.AbstractKrishaAdEntity;
import kz.maks.realestate.parser.services.RegionService;
import kz.maks.realestate.shared.dtos.get.AbstractKrishaAdGetDto;

import java.math.BigDecimal;

public abstract class AbstractKrishaAdAssembler<DTO extends AbstractKrishaAdGetDto, ENTITY extends AbstractKrishaAdEntity>
        implements IAssembler<DTO, ENTITY> {

    @Inject
    private RegionService regionService;

    @Override
    public ENTITY assemble(DTO dto, ENTITY entity) {
        entity.setId(dto.getId());
        entity.setKrishaId(dto.getKrishaId());
//        entity.setUpdatedAt(dto.getUpdatedAt().getTime());
        entity.setCenaProdazhi(dto.getCenaProdazhi() != null ? BigDecimal.valueOf(dto.getCenaProdazhi()) : null);
        entity.setValyuta(dto.getValyuta());
        {
            if (dto.getRegionKrishaId() != null)
                entity.setRegion(regionService.get(dto.getRegionKrishaId()));

            else if (dto.getRegionId() != null)
                entity.setRegion(regionService.get(dto.getRegionId()));
        }
        entity.setUlica(dto.getUlica());
        entity.setPeresechenie(dto.getPeresechenie());
        entity.setDom(dto.getDom());
        entity.setRaznoe(dto.getRaznoe());
        entity.setPrimechanie(dto.getPrimechanie());
        entity.setTelNumbers(dto.getTelNumbers());
//        entity.setPhotoPaths(dto.getPhotoPaths());
        entity.setIstochnikInfo(dto.getIstochnikInfo());
        return entity;
    }
}
