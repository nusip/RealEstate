package kz.maks.realestate.front;

import kz.maks.core.front.BaseClient;
import kz.maks.core.front.ClientConfig;
import kz.maks.realestate.front.services.FrontRemotes;
import kz.maks.realestate.front.ui.MainWindowController;

import javax.swing.*;

public class FrontClient extends BaseClient {

    public FrontClient() {
        super(new ClientConfig(FrontRemotes.class, true));
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
