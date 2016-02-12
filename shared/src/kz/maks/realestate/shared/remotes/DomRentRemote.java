package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DomRentRemote extends Remote {

    ListResponse<DomRentListDto> list(DomRentSearchParams params) throws RemoteException;

    DomRentGetDto get(Long id) throws RemoteException;

    void save(DomRentGetDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

}
