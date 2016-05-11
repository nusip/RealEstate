package kz.maks.realestate.center.assemblers.entity;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.center.entities.Device;
import kz.maks.realestate.center.services.ClientDeviceService;
import kz.maks.realestate.shared.dtos.DeviceDto;

@Bean
public class DeviceAssembler implements IAssembler<DeviceDto, Device> {

    @Inject
    private ClientDeviceService clientDeviceService;

    @Override
    public Device assemble(DeviceDto deviceDto, Device device) {
        device.setId(deviceDto.getId());
        device.setClient(deviceDto != null ? clientDeviceService.getClient(deviceDto.getClientId()) : null);
        device.setNumber(deviceDto.getNumber());
        device.setIsActive(deviceDto.getIsActive());
        return device;
    }

}
