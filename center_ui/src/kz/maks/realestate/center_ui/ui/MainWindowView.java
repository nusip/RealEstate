package kz.maks.realestate.center_ui.ui;

import kz.maks.core.front.FrontUtils;
import kz.maks.realestate.center_ui.ui.client.ClientView;
import kz.maks.realestate.center_ui.ui.device.DeviceView;

import javax.swing.*;

import java.awt.*;

import static kz.maks.realestate.shared.AppMeta.PROJECT_NAME;
import static kz.maks.realestate.shared.AppMeta.getVersion;

public class MainWindowView {
    public final JFrame ui;
    public final JTabbedPane mainTabs;
    public final ClientView clientView;
    public final DeviceView deviceView;

    public MainWindowView() {
        ui = new JFrame();
        ui.setTitle(PROJECT_NAME + " " + getVersion());
        {
            mainTabs = new JTabbedPane();
            FrontUtils.addMargins(mainTabs);
            {
                clientView = new ClientView(ui);
                mainTabs.addTab("Клиенты", clientView.ui);
            }
            {
                deviceView = new DeviceView(ui);
                mainTabs.add("Устройства", deviceView.ui);
            }
            ui.getContentPane().add(mainTabs);
        }
        ui.pack();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ui.setVisible(true);
        ui.setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.jpg")));
    }
}
