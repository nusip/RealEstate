package kz.maks.realestate.center_ui.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.center_ui.services.asyncs.DeviceAsync;
import kz.maks.realestate.shared.dtos.DeviceDto;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;

public class DeviceAsyncImpl implements DeviceAsync {
    @Override
    public void delete(Long id, Callback<Void> callback) {

    }

    @Override
    public void get(Long id, Callback<DeviceDto> callback) {

    }

    @Override
    public void list(DeviceSearchParams deviceSearchParams, Callback<ListResponse<DeviceDto>> callback) {

    }

    @Override
    public void save(DeviceDto deviceDto, Callback<Void> callback) {

    }
}
