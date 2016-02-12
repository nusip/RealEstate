package kz.maks.realestate.front.ui;

import kz.maks.core.front.FrontUtils;
import kz.maks.core.front.ui.*;
import kz.maks.realestate.front.ui.dom.DomRentView;
import kz.maks.realestate.front.ui.dom.DomSaleView;
import kz.maks.realestate.front.ui.kvartira.KvartiraRentView;
import kz.maks.realestate.front.ui.kvartira.KvartiraSaleView;
import kz.maks.realestate.shared.AppMeta;

import javax.swing.*;

public class MainWindowView {
    public final JFrame ui;
    public final KvartiraSaleView kvartiraSaleView;
    public final KvartiraRentView kvartiraRentView;
    public final DomSaleView domSaleView;
    public final DomRentView domRentView;

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
            frame.getContentPane().add(tabs);
        }
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        ui = frame;
    }

}
