package kz.maks.realestate.center.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.realestate.center.services.ActivationService;
import kz.maks.realestate.shared.remotes.ActivationRemote;

import java.rmi.RemoteException;

@Remote
public class ActivationRemoteImpl extends AbstractRemoteImpl implements ActivationRemote {

    @Inject(proxy = true)
    private ActivationService activationService;

    public ActivationRemoteImpl() throws RemoteException {}

    @Override
    public boolean isDeviceAllowed(String deviceNumber) throws RemoteException {
        return activationService.isDeviceAllowed(deviceNumber);
    }

}
