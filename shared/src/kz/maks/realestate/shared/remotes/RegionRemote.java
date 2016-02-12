package kz.maks.realestate.shared.remotes;

import kz.maks.realestate.shared.dtos.get.RegionDto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegionRemote extends Remote {

    RegionDto getRoot() throws RemoteException;

}
