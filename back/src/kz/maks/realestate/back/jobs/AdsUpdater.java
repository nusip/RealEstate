package kz.maks.realestate.back.jobs;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.back.BackRemotes;
import kz.maks.realestate.parser.services.KvartiraSaleService;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Bean
public class AdsUpdater {

    @Inject(proxy = true)
    private KvartiraSaleService kvartiraSaleService;

    public void update() throws RemoteException {
        Date maxUpdatedAt = kvartiraSaleService.getMaxUpdatedAt();
        List<KvartiraSaleDto> dtoList = BackRemotes.kvartiraSaleRemote().listNew(maxUpdatedAt);

        for (KvartiraSaleDto dto : dtoList) {
            dto.setId(null);
            kvartiraSaleService.save(dto);
        }
    }

}
