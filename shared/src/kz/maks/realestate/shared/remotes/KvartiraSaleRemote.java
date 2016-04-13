package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface KvartiraSaleRemote extends Remote {

    ListResponse<KvartiraSaleDto> list(KvartiraSaleSearchParams params) throws RemoteException;

    KvartiraSaleDto get(Long id) throws RemoteException;

    void save(KvartiraSaleDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

    List<KvartiraSaleDto> listNew(Date lastUpdatedAt) throws RemoteException;

    List<KvartiraSaleDto> listHistory(Long id) throws RemoteException;

}
