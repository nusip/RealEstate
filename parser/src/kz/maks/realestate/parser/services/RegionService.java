package kz.maks.realestate.parser.services;

import kz.maks.realestate.parser.entities.Region;
import kz.maks.realestate.parser.models.KrishaRegion;
import kz.maks.realestate.shared.dtos.RegionDto;

import java.util.List;

public interface RegionService {

    Region get(Long id);

    Region get(String krishaId);

    boolean hasAnyRegion();

    Region getRegionByName(String name);

    Region getRegionByNameAndParent(String name, String parentName);

    void saveRootRegions(List<KrishaRegion> regions);

    RegionDto getRoot();

    void saveRootRegion(RegionDto regionDto);

}
