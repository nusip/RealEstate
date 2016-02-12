package kz.maks.realestate.shared.remotes;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ActivationRemote extends Remote {

    boolean isDeviceAllowed(String deviceNumber) throws RemoteException;

}
