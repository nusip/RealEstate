package kz.maks.realestate.front.ui.login;

import kz.maks.core.front.services.asyncs.CoreAsyncs;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.realestate.front.ui.MainWindowController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LoginController {
    private final LoginView view = new LoginView();

    public LoginController() {
        view.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        view.ui.getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    public void login() {
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

}
