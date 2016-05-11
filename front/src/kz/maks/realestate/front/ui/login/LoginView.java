package kz.maks.realestate.front.ui.login;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.ProgressGlassPane;
import kz.maks.realestate.front.ui.MainWindowView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LoginView {
    public final JFrame ui;
    public final JButton btnLogin;
    public final JTextField login;
    public final JTextField pass;

    public LoginView() {
        ui = new JFrame() {
            @Override
            public Dimension getPreferredSize() {
                return FrontUtils.fitWindowSize(super.getPreferredSize());
            }
        };
        ui.setGlassPane(new ProgressGlassPane());
        ui.setLayout(new BoxLayout(ui.getContentPane(), BoxLayout.Y_AXIS));
        ui.setTitle("Форма входа в систему");
        {
            Box vBox = Box.createVerticalBox();
            FrontUtils.addMargins(vBox);
            {
                {
                    Box hBox = Box.createHorizontalBox();
                    JLabel label = new JLabel("Логин");
                    hBox.add(label);
                    hBox.add(Box.createHorizontalGlue());
                    vBox.add(hBox);
                }
                {
                    Box hBox = Box.createHorizontalBox();
                    login = new JTextField();
                    hBox.add(login);
                    vBox.add(hBox);
                }
                vBox.add(FrontUtils.vGap());
                {
                    Box hBox = Box.createHorizontalBox();
                    JLabel label = new JLabel("Пароль");
                    hBox.add(label);
                    hBox.add(Box.createHorizontalGlue());
                    vBox.add(hBox);
                }
                {
                    Box hBox = Box.createHorizontalBox();
                    pass = new JPasswordField();
                    hBox.add(pass);
                    vBox.add(hBox);
                }
                vBox.add(FrontUtils.vGap());
                vBox.add(FrontUtils.vGap());
                {
                    JPanel panel = new JPanel(new BorderLayout());
                    btnLogin = new JButton("Войти");
                    panel.add(btnLogin, BorderLayout.CENTER);
                    vBox.add(panel);
                }
                vBox.add(FrontUtils.vGap());
            }
            FrontUtils.setForcedWidth(vBox, 200);
            ui.add(vBox);
        }
        ui.pack();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setLocationRelativeTo(null);
        ui.setResizable(false);
        ui.setVisible(true);
        ui.setIconImage(Toolkit.getDefaultToolkit().createImage(MainWindowView.class.getResource("icon.jpg")));

        ui.getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.setVisible(false);
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

}
