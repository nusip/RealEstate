package kz.maks.realestate.center.services.remotes;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Remote;
import kz.maks.core.back.services.remotes.AbstractRemoteImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.center.services.ClientDeviceService;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.DeviceDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;
import kz.maks.realestate.shared.remotes.ClientDeviceRemote;

import java.rmi.RemoteException;

@Remote
public class ClientDeviceRemoteImpl extends AbstractRemoteImpl implements ClientDeviceRemote {

    @Inject(proxy = true)
    private ClientDeviceService service;

    public ClientDeviceRemoteImpl() throws RemoteException {}

    @Override
    public ListResponse<ClientDto> listClients(ClientSearchParams params) throws RemoteException {
        return service.listClients(params);
    }

    @Override
    public ClientDto getClient(Long id) throws RemoteException {
        return service.getClientDto(id);
    }

    @Override
    public void saveClient(ClientDto clientDto) throws RemoteException {
        service.saveClient(clientDto);
    }

    @Override
    public void deleteClient(Long id) throws RemoteException {
        service.deleteClient(id);
    }

    @Override
    public ListResponse<DeviceDto> listDevices(DeviceSearchParams params) throws RemoteException {
        return service.listDevices(params);
    }

    @Override
    public DeviceDto getDevice(Long id) throws RemoteException {
        return service.getDeviceDto(id);
    }

    @Override
    public void saveDevice(DeviceDto deviceDto) throws RemoteException {
        service.saveDevice(deviceDto);
    }

    @Override
    public void deleteDevice(Long id) throws RemoteException {
        service.deleteDevice(id);
    }
}
