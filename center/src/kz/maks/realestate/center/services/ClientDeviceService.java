package kz.maks.realestate.center.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.center.entities.Client;
import kz.maks.realestate.center.entities.Device;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.DeviceDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;

public interface ClientDeviceService {

    ListResponse<ClientDto> listClients(ClientSearchParams params);

    Client getClient(Long id);

    ClientDto getClientDto(Long id);

    void saveClient(ClientDto clientDto);

    void deleteClient(Long id);

    ListResponse<DeviceDto> listDevices(DeviceSearchParams params);

    Device getDevice(Long id);

    DeviceDto getDeviceDto(Long id);

    void saveDevice(DeviceDto deviceDto);

    void deleteDevice(Long id);

}
