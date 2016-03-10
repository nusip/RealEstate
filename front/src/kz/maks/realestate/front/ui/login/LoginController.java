package kz.maks.realestate.front.ui.login;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.CoreAsyncs;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.front.ui.MainWindowController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    public LoginController() {
        final LoginView view = new LoginView();

        view.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoreAsyncs.CORE_ASYNC.login(view.login.getText(), view.pass.getText(),
                        new ProgressDialogCallback<Boolean>(view.ui) {
                            @Override
                            public void onSuccess(Boolean aBoolean) {
                                if (Boolean.TRUE.equals(aBoolean)) {
                                    view.ui.setVisible(false);
                                    new MainWindowController();
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Введены неверные данные", "Ошибка",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        });
            }
        });
    }

}
