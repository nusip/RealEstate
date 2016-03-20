package kz.maks.realestate.parser.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.services.KvartiraRentService;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;
import kz.maks.realestate.shared.remotes.KvartiraRentRemote;

import java.rmi.RemoteException;

@Remote
public class KvartiraRentRemoteImpl extends AbstractRemoteImpl implements KvartiraRentRemote {

    @Inject(proxy = true)
    private KvartiraRentService service;

    public KvartiraRentRemoteImpl() throws RemoteException {}

    @Override
    public void save(KvartiraRentDto dto) throws RemoteException {
        service.save(dto);
    }

    @Override
    public void delete(Long id) throws RemoteException {
        service.delete(id);
    }

    @Override
    public KvartiraRentDto get(Long id) throws RemoteException{
        return service.get(id);
    }

    @Override
    public ListResponse<KvartiraRentDto> list(KvartiraRentSearchParams params) throws RemoteException {
        return service.list(params);
    }

}
