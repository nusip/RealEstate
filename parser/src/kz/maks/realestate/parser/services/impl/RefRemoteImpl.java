package kz.maks.realestate.parser.services.impl;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.parser.services.RefService;
import kz.maks.realestate.shared.refs.Ref;
import kz.maks.realestate.shared.remotes.RefRemote;

import java.rmi.RemoteException;
import java.util.List;

@Remote
public class RefRemoteImpl extends AbstractRemoteImpl implements RefRemote {

    @Inject(proxy = true)
    private RefService refService;

    public RefRemoteImpl() throws RemoteException {}

    @Override
    public List<RefDto> list(Ref ref) throws RemoteException {
        return refService.list(ref);
    }

    @Override
    public void save(Ref ref, List<RefDto> dtos) throws RemoteException {
        refService.save(ref, dtos);
    }

}
