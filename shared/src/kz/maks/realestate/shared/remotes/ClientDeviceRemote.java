package kz.maks.realestate.shared.remotes;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.DeviceDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientDeviceRemote extends Remote {

    ListResponse<ClientDto> listClients(ClientSearchParams params) throws RemoteException;

    ClientDto getClient(Long id) throws RemoteException;

    void saveClient(ClientDto clientDto) throws RemoteException;

    void deleteClient(Long id) throws RemoteException;

    ListResponse<DeviceDto> listDevices(DeviceSearchParams params) throws RemoteException;

    DeviceDto getDevice(Long id) throws RemoteException;

    void saveDevice(DeviceDto deviceDto) throws RemoteException;

    void deleteDevice(Long id) throws RemoteException;

}
