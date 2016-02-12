package kz.maks.realestate.parser.assemblers.getDto;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.Region;
import kz.maks.realestate.shared.dtos.get.RegionDto;

@Bean
public class RegionDtoAssembler implements IAssembler<Region, RegionDto> {

    @Override
    public RegionDto assemble(Region region, RegionDto dto) {
        dto.setId(region.getId());
        dto.setName(region.getName());
        // set null in order to avoid unlimited recursion
        dto.setParent(null);
        dto.setKrishaId(region.getKrishaId());
        dto.setKrishaAlias(region.getKrishaAlias());
        dto.setPath(region.getPath());
        dto.setUpdatedAt(region.getUpdatedAt());
        dto.setDeleted(region.getDeleted());

        for (Region child : region.getChildren()) {
            dto.getChildren().add(assemble(child, new RegionDto()));
        }

        return dto;
    }

}
