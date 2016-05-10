package kz.maks.realestate.center_ui;

import kz.maks.core.front.BaseClient;
import kz.maks.core.front.ClientConfig;
import kz.maks.realestate.center_ui.services.CenterUIRemotes;
import kz.maks.realestate.center_ui.ui.MainWindowController;

import javax.swing.*;

public class CenterUIClient extends BaseClient {

    public CenterUIClient() {
        super(new ClientConfig(CenterUIRemotes.class, true));
    }

    @Override
    public void afterInit() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        new MainWindowController();

    }

}
