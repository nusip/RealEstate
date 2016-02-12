package kz.maks.realestate.back.jobs;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.back.BackRemotes;
import kz.maks.realestate.parser.services.KvartiraSaleService;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;

import java.rmi.RemoteException;
import java.util.List;

@Bean
public class AdsUpdater {

    @Inject(proxy = true)
    private KvartiraSaleService kvartiraSaleService;

    public void update() throws RemoteException {
        Long maxUpdatedAt = kvartiraSaleService.getMaxUpdatedAt();
        List<KvartiraSaleGetDto> dtoList = BackRemotes.kvartiraSaleRemote().listNew(maxUpdatedAt);

        for (KvartiraSaleGetDto dto : dtoList) {
            dto.setId(null);
            kvartiraSaleService.save(dto);
        }
    }

}
