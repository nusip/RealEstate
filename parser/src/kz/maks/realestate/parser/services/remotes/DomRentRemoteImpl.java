package kz.maks.realestate.parser.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.services.DomRentService;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;
import kz.maks.realestate.shared.remotes.DomRentRemote;

import java.rmi.RemoteException;

@Remote
public class DomRentRemoteImpl extends AbstractRemoteImpl implements DomRentRemote {

    @Inject(proxy = true)
    private DomRentService service;

    public DomRentRemoteImpl() throws RemoteException {}

    @Override
    public void save(DomRentGetDto dto) throws RemoteException {
        service.save(dto);
    }

    @Override
    public void delete(Long id) throws RemoteException {
        service.delete(id);
    }

    @Override
    public DomRentGetDto get(Long id) throws RemoteException{
        return service.get(id);
    }

    @Override
    public ListResponse<DomRentListDto> list(DomRentSearchParams params) throws RemoteException {
        return service.list(params);
    }

}
