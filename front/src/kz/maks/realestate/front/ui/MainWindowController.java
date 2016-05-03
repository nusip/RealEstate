package kz.maks.realestate.front.ui;

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

public class MainWindowController {

    public MainWindowController() {
        MainWindowView view = new MainWindowView();

        new KvartiraSaleController(view.kvartiraSaleView);
        new KvartiraRentController(view.kvartiraRentView);

        new DomSaleController(view.domSaleView);
        new DomRentController(view.domRentView);

        for (Ref ref : Ref.values()) {
            final RefManagementController refController = new RefManagementController(view.refRefManagementViewMap.get(ref));

            view.refs.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    refController.refresh();
                }
            });
        }

        new RealtorController(view.realtorView);

        new UserController(view.userView);
    }

}
