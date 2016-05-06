package kz.maks.realestate.front.ui;

import kz.maks.core.front.FrontUtils;
import kz.maks.realestate.front.ConnectedUser;
import kz.maks.realestate.front.ui.dom.DomRentView;
import kz.maks.realestate.front.ui.dom.DomSaleView;
import kz.maks.realestate.front.ui.kvartira.KvartiraRentView;
import kz.maks.realestate.front.ui.kvartira.KvartiraSaleView;
import kz.maks.realestate.front.ui.realtors.RealtorView;
import kz.maks.realestate.front.ui.refs.RefManagementView;
import kz.maks.realestate.front.ui.users.UserView;
import kz.maks.realestate.shared.refs.Ref;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.SwingConstants.LEFT;
import static kz.maks.realestate.shared.AppMeta.PROJECT_NAME;
import static kz.maks.realestate.shared.AppMeta.getVersion;

public class MainWindowView {
    public final JFrame ui;
    public final KvartiraSaleView kvartiraSaleView;
    public final KvartiraRentView kvartiraRentView;
    public final DomSaleView domSaleView;
    public final DomRentView domRentView;
    public final Map<Ref, RefManagementView> refRefManagementViewMap = new HashMap<>();
    public final JTabbedPane refTabs;
    public final JTabbedPane mainTabs;
    public final RealtorView realtorView;
    public final UserView userView;

    public MainWindowView() {
        JFrame frame = new JFrame();
        frame.setTitle(PROJECT_NAME + " " + getVersion()
                + " --- ( Текущий пользователь: " + ConnectedUser.get().getFullName() + " )");
        {
            mainTabs = new JTabbedPane();
            FrontUtils.addMargins(mainTabs);
            {
                JTabbedPane subTabs = new JTabbedPane();
                FrontUtils.addMargins(subTabs);
                mainTabs.addTab("Продажа", subTabs);
                {
                    kvartiraSaleView = new KvartiraSaleView(frame);
                    subTabs.addTab("Квартиры", kvartiraSaleView.ui);
                }
                {
                    domSaleView = new DomSaleView(frame);
                    subTabs.addTab("Дома", domSaleView.ui);
                }
            }
            {
                JTabbedPane subTabs = new JTabbedPane();
                FrontUtils.addMargins(subTabs);
                mainTabs.addTab("Аренда", subTabs);
                {
                    kvartiraRentView = new KvartiraRentView(frame);
                    subTabs.addTab("Квартиры", kvartiraRentView.ui);
                }
                {
                    domRentView = new DomRentView(frame);
                    subTabs.addTab("Дома", domRentView.ui);
                }
            }
            {
                realtorView = new RealtorView(frame);
                mainTabs.addTab("Риэлторы", realtorView.ui);
            }
            {
                refTabs = new JTabbedPane(LEFT);

                for (Ref ref : Ref.values()) {
                    RefManagementView refManagementView = new RefManagementView(frame, ref);
                    refTabs.addTab(ref.getTitle(), refManagementView.ui);
                    refRefManagementViewMap.put(ref, refManagementView);
                }
                mainTabs.addTab("Справочники", refTabs);
            }
            {
                userView = new UserView(frame);

                if (ConnectedUser.isRoot()) {
                    mainTabs.addTab("Пользователи", userView.ui);
                }
            }
            frame.getContentPane().add(mainTabs);
        }
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        ui = frame;
    }

}
