package kz.maks.realestate.parser.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.services.RealtorService;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;
import kz.maks.realestate.shared.remotes.RealtorRemote;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Remote
public class RealtorRemoteImpl extends AbstractRemoteImpl implements RealtorRemote {

    @Inject(proxy = true)
    private RealtorService service;

    public RealtorRemoteImpl() throws RemoteException {}

    @Override
    public ListResponse<RealtorDto> list(RealtorSearchParams params) throws RemoteException {
        return service.list(params);
    }

    @Override
    public List<RealtorDto> listNew(Date lastUpdatedAt) throws RemoteException {
        return service.listNew(lastUpdatedAt);
    }

}
