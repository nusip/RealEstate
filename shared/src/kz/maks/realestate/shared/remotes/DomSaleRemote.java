package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.get.dom.DomSaleGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomSaleListDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DomSaleRemote extends Remote {

    ListResponse<DomSaleListDto> list(DomSaleSearchParams params) throws RemoteException;

    DomSaleGetDto get(Long id) throws RemoteException;

    void save(DomSaleGetDto dto) throws RemoteException;

    void delete(Long id) throws RemoteException;

}
