package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface KvartiraSaleRemote extends Remote {

    ListResponse<KvartiraSaleListDto> list(KvartiraSaleSearchParams params) throws RemoteException;

    KvartiraSaleGetDto get(Long id) throws RemoteException;

    void save(KvartiraSaleGetDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

    List<KvartiraSaleGetDto> listNew(Long lastUpdatedAt) throws RemoteException;

}
