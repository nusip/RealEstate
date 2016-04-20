package kz.maks.realestate.front.ui.dom;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

public class DomRentController {
    private final DomRentView view;

    public DomRentController(DomRentView view) {
        this.view = view;

        CRUD<DomRentSearchParams, DomRentDto, DomRentDto> crud = new CRUD<>(
                view.frame,
                new SearchPanel<>(DomRentSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.DOM_RENT_ASYNC
        );
    }
}
