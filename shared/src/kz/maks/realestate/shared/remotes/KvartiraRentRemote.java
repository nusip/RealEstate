package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KvartiraRentRemote extends Remote {

    ListResponse<KvartiraRentDto> list(KvartiraRentSearchParams params) throws RemoteException;

    KvartiraRentDto get(Long id) throws RemoteException;

    void save(KvartiraRentDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

}
