package kz.maks.realestate.parser.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.services.DomSaleService;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;
import kz.maks.realestate.shared.remotes.DomSaleRemote;

import java.rmi.RemoteException;

@Remote
public class DomSaleRemoteImpl extends AbstractRemoteImpl implements DomSaleRemote {

    @Inject(proxy = true)
    private DomSaleService service;

    public DomSaleRemoteImpl() throws RemoteException {}

    @Override
    public void save(DomSaleDto dto) throws RemoteException {
        service.save(dto);
    }

    @Override
    public void delete(Long id) throws RemoteException {
        service.delete(id);
    }

    @Override
    public DomSaleDto get(Long id) throws RemoteException{
        return service.get(id);
    }

    @Override
    public ListResponse<DomSaleDto> list(DomSaleSearchParams params) throws RemoteException {
        return service.list(params);
    }

}
