package kz.maks.realestate.center_ui.services;

import kz.maks.realestate.shared.remotes.*;

public class CenterUIRemotes {
    private static ClientDeviceRemote clientDeviceRemote;

    public static ClientDeviceRemote clientDeviceRemote() {
        return clientDeviceRemote;
    }
}
