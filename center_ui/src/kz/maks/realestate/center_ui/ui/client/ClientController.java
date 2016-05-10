package kz.maks.realestate.center_ui.ui.client;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.center_ui.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;

public class ClientController {

    public ClientController(ClientView view) {
        new CRUD<>(
                view.rootFrame,
                new SearchPanel<>(ClientSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.CLIENT_ASYNC
        );
    }

}
