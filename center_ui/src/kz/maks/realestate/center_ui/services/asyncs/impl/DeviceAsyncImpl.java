package kz.maks.realestate.center_ui.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.center_ui.services.CenterUIRemotes;
import kz.maks.realestate.center_ui.services.asyncs.DeviceAsync;
import kz.maks.realestate.shared.dtos.DeviceDto;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;

import java.util.concurrent.Callable;

import static kz.maks.realestate.center_ui.services.CenterUIRemotes.clientDeviceRemote;

public class DeviceAsyncImpl extends AbstractAsyncImpl implements DeviceAsync {
    @Override
    public void delete(final Long id, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                clientDeviceRemote().deleteDevice(id);
                return null;
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<DeviceDto> callback) {
        executeAsync(new Callable<DeviceDto>() {
            @Override
            public DeviceDto call() throws Exception {
                return clientDeviceRemote().getDevice(id);
            }
        }, callback);
    }

    @Override
    public void list(final DeviceSearchParams deviceSearchParams, Callback<ListResponse<DeviceDto>> callback) {
        executeAsync(new Callable<ListResponse<DeviceDto>>() {
            @Override
            public ListResponse<DeviceDto> call() throws Exception {
                return clientDeviceRemote().listDevices(deviceSearchParams);
            }
        }, callback);
    }

    @Override
    public void save(final DeviceDto deviceDto, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                clientDeviceRemote().saveDevice(deviceDto);
                return null;
            }
        }, callback);
    }
}
