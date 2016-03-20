package kz.maks.realestate.shared.remotes;

import kz.maks.realestate.shared.dtos.UserDto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserRemote extends Remote {

    UserDto get(String identifier, String credentials) throws RemoteException;

}
