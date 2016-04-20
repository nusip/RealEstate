package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

public class KvartiraRentController {
    private final KvartiraRentView view;

    public KvartiraRentController(KvartiraRentView view) {
        this.view = view;

        CRUD<KvartiraRentSearchParams, KvartiraRentDto, KvartiraRentDto> crud = new CRUD<>(
                view.frame,
                new SearchPanel<>(KvartiraRentSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.KVARTIRA_RENT_ASYNC
        );
    }
}
