package kz.maks.realestate.center.assemblers.dto;

import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.center.entities.Client;
import kz.maks.realestate.center.entities.Device;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.DeviceDto;

import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.core.shared.Utils.extractName;
import static kz.maks.core.shared.Utils.extractTitles;

public class DeviceDtoAssembler implements IAssembler<Device, DeviceDto> {

    @Override
    public DeviceDto assemble(Device device, DeviceDto deviceDto) {
        deviceDto.setId(device.getId());
        deviceDto.setClientId(extractId(device.getClient()));
        deviceDto.setClientName(extractName(device.getClient()));
        deviceDto.setNumber(device.getNumber());
        deviceDto.setIsActive(Boolean.TRUE.equals(device.getIsActive()));
        return deviceDto;
    }

}
