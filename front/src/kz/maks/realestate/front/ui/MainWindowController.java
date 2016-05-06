package kz.maks.realestate.front.ui;

import kz.maks.realestate.front.ConnectedUser;
import kz.maks.realestate.front.ui.dom.DomRentController;
import kz.maks.realestate.front.ui.dom.DomSaleController;
import kz.maks.realestate.front.ui.kvartira.KvartiraRentController;
import kz.maks.realestate.front.ui.kvartira.KvartiraSaleController;
import kz.maks.realestate.front.ui.realtors.RealtorController;
import kz.maks.realestate.front.ui.refs.RefManagementController;
import kz.maks.realestate.front.ui.users.UserController;
import kz.maks.realestate.shared.refs.Ref;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.HashMap;
import java.util.Map;

public class MainWindowController {

    public MainWindowController() {
        final MainWindowView view = new MainWindowView();

        new KvartiraSaleController(view.kvartiraSaleView);
        new KvartiraRentController(view.kvartiraRentView);

        new DomSaleController(view.domSaleView);
        new DomRentController(view.domRentView);

        final Map<Ref, RefManagementController> refControllers = new HashMap<>();

        for (Ref ref : Ref.values()) {
            final RefManagementController refController = new RefManagementController(view.refRefManagementViewMap.get(ref));
            refControllers.put(ref, refController);
            view.refTabs.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    refController.refresh();
                }
            });
        }

        view.mainTabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (view.mainTabs.getSelectedComponent() == view.refTabs) {
                    int selectedRefIndex = view.refTabs.getSelectedIndex();
                    refControllers.get(Ref.values()[selectedRefIndex]).refresh();
                }
            }
        });

        new RealtorController(view.realtorView);

        if (ConnectedUser.isRoot()) {
            new UserController(view.userView);
        }
    }

}
