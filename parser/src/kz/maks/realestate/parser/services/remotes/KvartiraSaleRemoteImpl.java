package kz.maks.realestate.parser.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.services.KvartiraSaleService;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;
import kz.maks.realestate.shared.remotes.KvartiraSaleRemote;

import java.rmi.RemoteException;
import java.util.List;

@Remote
public class KvartiraSaleRemoteImpl extends AbstractRemoteImpl implements KvartiraSaleRemote {

    @Inject(proxy = true)
    private KvartiraSaleService service;

    public KvartiraSaleRemoteImpl() throws RemoteException {}

    @Override
    public void save(KvartiraSaleGetDto dto) throws RemoteException {
        service.save(dto);
    }

    @Override
    public void delete(Long id) throws RemoteException {
        service.delete(id);
    }

    @Override
    public List<KvartiraSaleGetDto> listNew(Long lastUpdatedAt) throws RemoteException {
        return service.listNew(lastUpdatedAt);
    }

    @Override
    public KvartiraSaleGetDto get(Long id) throws RemoteException {
        return service.get(id);
    }

    @Override
    public ListResponse<KvartiraSaleListDto> list(KvartiraSaleSearchParams params) throws RemoteException {
        return service.list(params);
    }

}
