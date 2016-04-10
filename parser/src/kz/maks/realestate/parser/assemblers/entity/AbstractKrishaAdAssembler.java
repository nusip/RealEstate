package kz.maks.realestate.parser.assemblers.entity;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.AbstractKrishaAdEntity;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.parser.entities.refs.IstochnikInfo;
import kz.maks.realestate.parser.entities.refs.Valyuta;
import kz.maks.realestate.parser.services.RefService;
import kz.maks.realestate.parser.services.RegionService;
import kz.maks.realestate.parser.services.UserService;
import kz.maks.realestate.shared.dtos.AbstractKrishaAdDto;
import kz.maks.realestate.shared.refs.Ref;

import java.math.BigDecimal;

public abstract class AbstractKrishaAdAssembler<DTO extends AbstractKrishaAdDto, ENTITY extends AbstractKrishaAdEntity>
        implements IAssembler<DTO, ENTITY> {

    @Inject
    private RegionService regionService;

    @Inject
    private UserService userService;

    @Inject
    private RefService refService;

    @Override
    public ENTITY assemble(DTO dto, ENTITY entity) {
        entity.setId(dto.getId());
        entity.setKrishaId(dto.getKrishaId());
        entity.setCena(dto.getCena() != null ? BigDecimal.valueOf(dto.getCena()) : null);
        entity.setCenaProdazhi(dto.getCenaProdazhi() != null ? BigDecimal.valueOf(dto.getCenaProdazhi()) : null);

        if (dto.getValyutaId() != null) {
            Valyuta valyuta = (Valyuta) refService.get(Ref.Valyuta, dto.getValyutaId());
            entity.setValyuta(valyuta);
        }
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

        if (dto.getIstochnikInfoId() != null) {
            IstochnikInfo istochnikInfo = (IstochnikInfo) refService.get(Ref.IstochnikInfo, dto.getIstochnikInfoId());
            entity.setIstochnikInfo(istochnikInfo);
        }

        if (dto.getAssignedToId() != null) {
            User user = userService.get(dto.getAssignedToId());
            entity.setAssignedTo(user);
        }

        if (dto.getModifiedById() != null) {
            User user = userService.get(dto.getModifiedById());
            entity.setModifiedBy(user);
        }

        entity.setIsArchive(dto.getIsArchive());

        return entity;
    }
}
