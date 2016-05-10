package kz.maks.realestate.center_ui.ui;

import kz.maks.realestate.center_ui.ui.client.ClientController;
import kz.maks.realestate.center_ui.ui.device.DeviceController;

public class MainWindowController {

    public MainWindowController() {
        MainWindowView view = new MainWindowView();
        new ClientController(view.clientView);
        new DeviceController(view.deviceView);
    }

}
