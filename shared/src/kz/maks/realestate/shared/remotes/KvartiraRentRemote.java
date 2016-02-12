package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraRentListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KvartiraRentRemote extends Remote {

    ListResponse<KvartiraRentListDto> list(KvartiraRentSearchParams params) throws RemoteException;

    KvartiraRentGetDto get(Long id) throws RemoteException;

    void save(KvartiraRentGetDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

}
