package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DomRentRemote extends Remote {

    ListResponse<DomRentDto> list(DomRentSearchParams params) throws RemoteException;

    DomRentDto get(Long id) throws RemoteException;

    void save(DomRentDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

}
