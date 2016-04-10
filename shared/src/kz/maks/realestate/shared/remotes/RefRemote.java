package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.shared.refs.Ref;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RefRemote extends Remote {

    List<RefDto> list(Ref ref) throws RemoteException;

    void save(Ref ref, List<RefDto> dtos) throws RemoteException;

}
