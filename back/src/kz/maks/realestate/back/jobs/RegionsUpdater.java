package kz.maks.realestate.back.jobs;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.back.BackRemotes;
import kz.maks.realestate.parser.services.RegionService;
import kz.maks.realestate.shared.dtos.RegionDto;

import java.rmi.RemoteException;

@Bean
public class RegionsUpdater {

    @Inject(proxy = true)
    private RegionService regionService;

    public void update() {
        try {
            RegionDto regionDto = BackRemotes.regionRemote().getRoot();
            clearIds(regionDto);
            regionService.saveRootRegion(regionDto);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }

    private void clearIds(RegionDto regionDto) {
        regionDto.setId(null);
        regionDto.getChildren().forEach(this::clearIds);
    }

}
