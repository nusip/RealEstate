package kz.maks.realestate.center_ui.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.DeviceDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;

public interface DeviceAsync extends ICRUDAsync<DeviceSearchParams, DeviceDto, DeviceDto> {
    
}
