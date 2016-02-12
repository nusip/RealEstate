package kz.maks.realestate.front;

import kz.maks.core.front.BaseClient;
import kz.maks.core.front.ClientConfig;
import kz.maks.realestate.front.services.FrontRemotes;
import kz.maks.realestate.front.ui.MainWindowController;

import javax.swing.*;

import static kz.maks.core.shared.Utils.DEFAULT_RMI_REGISTRY_PORT;

public class FrontClient extends BaseClient {

    public FrontClient() {
        super(new ClientConfig("localhost", FrontRemotes.class, true, DEFAULT_RMI_REGISTRY_PORT));
    }

    @Override
    public void afterInit() {
        ActivationChecker.check();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        new MainWindowController();
    }

}
