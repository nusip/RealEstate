package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

public class DomSaleController {
    private final DomSaleView view;

    public DomSaleController(DomSaleView view) {
        this.view = view;

        CRUD<DomSaleSearchParams, DomSaleDto, DomSaleDto> crud = new CRUD<>(
                view.frame,
                new SearchPanel<>(DomSaleSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.DOM_SALE_ASYNC
        );
    }

}
