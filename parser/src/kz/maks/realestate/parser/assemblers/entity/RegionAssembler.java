package kz.maks.realestate.parser.assemblers.entity;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.Region;
import kz.maks.realestate.shared.dtos.RegionDto;

@Bean
public class RegionAssembler implements IAssembler<RegionDto, Region> {

    @Override
    public Region assemble(RegionDto regionDto, Region region) {
        region.setId(regionDto.getId());
        region.setName(regionDto.getName());
        region.setKrishaId(regionDto.getKrishaId());
        region.setKrishaAlias(regionDto.getKrishaAlias());
        region.setPath(regionDto.getPath());
        region.setUpdatedAt(regionDto.getUpdatedAt());
        region.setDeleted(regionDto.getDeleted());
        return region;
    }

}
