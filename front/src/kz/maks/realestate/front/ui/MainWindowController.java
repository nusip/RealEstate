package kz.maks.realestate.front.ui;

import kz.maks.realestate.front.ui.dom.DomRentController;
import kz.maks.realestate.front.ui.dom.DomSaleController;
import kz.maks.realestate.front.ui.kvartira.KvartiraRentController;
import kz.maks.realestate.front.ui.kvartira.KvartiraSaleController;

public class MainWindowController {

    public MainWindowController() {
        MainWindowView view = new MainWindowView();

        new KvartiraSaleController(view.kvartiraSaleView);
        new KvartiraRentController(view.kvartiraRentView);

        new DomSaleController(view.domSaleView);
        new DomRentController(view.domRentView);
    }

}
