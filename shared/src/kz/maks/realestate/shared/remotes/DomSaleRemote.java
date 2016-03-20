package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DomSaleRemote extends Remote {

    ListResponse<DomSaleDto> list(DomSaleSearchParams params) throws RemoteException;

    DomSaleDto get(Long id) throws RemoteException;

    void save(DomSaleDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

}
