package kz.maks.realestate.front.ui;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.ui.dom.DomRentView;
import kz.maks.realestate.front.ui.dom.DomSaleView;
import kz.maks.realestate.front.ui.kvartira.KvartiraRentView;
import kz.maks.realestate.front.ui.kvartira.KvartiraSaleView;
import kz.maks.realestate.front.ui.refs.RefManagementView;
import kz.maks.realestate.shared.AppMeta;
import kz.maks.realestate.shared.refs.Ref;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.SwingConstants.LEFT;

public class MainWindowView {
    public final JFrame ui;
    public final KvartiraSaleView kvartiraSaleView;
    public final KvartiraRentView kvartiraRentView;
    public final DomSaleView domSaleView;
    public final DomRentView domRentView;
    public final Map<Ref, RefManagementView> refRefManagementViewMap = new HashMap<>();
    public final JTabbedPane refs;

    public MainWindowView() {
        JFrame frame = new JFrame();
        frame.setGlassPane(new ProgressGlassPane());
        frame.setTitle(AppMeta.PROJECT_NAME + " " + AppMeta.getVersion());
        {
            JTabbedPane tabs = new JTabbedPane();
            FrontUtils.addMargins(tabs);
            {
                JTabbedPane subTabs = new JTabbedPane();
                FrontUtils.addMargins(subTabs);
                tabs.addTab("Продажа", subTabs);
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
                tabs.addTab("Аренда", subTabs);
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
                JPanel salesPanel = new JPanel();
                tabs.addTab("Риэлторы", salesPanel);
            }
            {
                refs = new JTabbedPane(LEFT);

                for (Ref ref : Ref.values()) {
                    RefManagementView refManagementView = new RefManagementView(frame, ref);
                    refs.addTab(ref.getTitle(), refManagementView.ui);
                    refRefManagementViewMap.put(ref, refManagementView);
                }
                tabs.addTab("Справочники", refs);
            }
            frame.getContentPane().add(tabs);
        }
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        ui = frame;
    }

}
