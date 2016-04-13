package kz.maks.realestate.back.jobs;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.back.BackRemotes;
import kz.maks.realestate.parser.services.RealtorService;
import kz.maks.realestate.shared.dtos.RealtorDto;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Bean
public class RealtorsUpdater {

    @Inject(proxy = true)
    private RealtorService realtorService;

    public void update() throws RemoteException {
        Date maxUpdatedAt = realtorService.getMaxUpdatedAt();
        List<RealtorDto> dtoList = BackRemotes.realtorRemote().listNew(maxUpdatedAt);

        for (RealtorDto dto : dtoList) {
            dto.setId(null);
            realtorService.save(dto);
        }
    }

}
