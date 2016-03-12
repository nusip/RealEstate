package kz.maks.realestate.front.ui.login;

import kz.maks.core.front.services.asyncs.CoreAsyncs;
import kz.maks.core.front.ui.ProgressDialogCallback;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.front.ui.MainWindowController;
import kz.maks.realestate.shared.AppMeta;
import kz.maks.realestate.shared.dtos.get.UserDto;

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
        Asyncs.USER_ASYNC.get(view.login.getText(), view.pass.getText(), new ProgressDialogCallback<UserDto>(view.ui) {
            @Override
            public void onSuccess(UserDto userDto) {
                if (userDto != null) {
                    AppMeta.setConnectedUser(userDto);
                    view.ui.setVisible(false);
                    new MainWindowController();
                } else {
                    JOptionPane.showMessageDialog(null, "Введены неверные данные", "Ошибка",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

}
