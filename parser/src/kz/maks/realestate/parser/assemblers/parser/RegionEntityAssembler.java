package kz.maks.realestate.parser.assemblers.parser;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.Region;
import kz.maks.realestate.parser.models.KrishaRegion;

@Bean
public class RegionEntityAssembler implements IAssembler<KrishaRegion, Region> {

    @Override
    public Region assemble(KrishaRegion krishaRegion, Region region) {
        region.setName(krishaRegion.getLabel());
        region.setKrishaId(krishaRegion.getId());
        region.setKrishaAlias(krishaRegion.getAlias());
        return region;
    }

}
