package kz.maks.realestate.back.services.remotes;

import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.realestate.back.BackRemotes;
import kz.maks.realestate.shared.remotes.ActivationRemote;

import java.rmi.RemoteException;

@Remote
public class ActivationRemoteImpl extends AbstractRemoteImpl implements ActivationRemote {

    public ActivationRemoteImpl() throws RemoteException {}

    @Override
    public boolean isDeviceAllowed(String deviceNumber) throws RemoteException {
        return BackRemotes.activationRemote().isDeviceAllowed(deviceNumber);
    }
}
