package kz.maks.realestate.center_ui.services.asyncs;

import kz.maks.realestate.center_ui.services.asyncs.impl.ClientAsyncImpl;
import kz.maks.realestate.center_ui.services.asyncs.impl.DeviceAsyncImpl;

public class Asyncs {
    public static final ClientAsync CLIENT_ASYNC = new ClientAsyncImpl();
    public static final DeviceAsync DEVICE_ASYNC = new DeviceAsyncImpl();
}
