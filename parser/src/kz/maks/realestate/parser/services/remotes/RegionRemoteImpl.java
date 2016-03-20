package kz.maks.realestate.parser.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.realestate.parser.services.RegionService;
import kz.maks.realestate.shared.dtos.RegionDto;
import kz.maks.realestate.shared.remotes.RegionRemote;

import java.rmi.RemoteException;

@Remote
public class RegionRemoteImpl extends AbstractRemoteImpl implements RegionRemote {

    @Inject(proxy = true)
    private RegionService regionService;

    public RegionRemoteImpl() throws RemoteException {}

    @Override
    public RegionDto getRoot() throws RemoteException {
        return regionService.getRoot();
    }

}
