package kz.maks.realestate.front.ui.kvartira;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

public class KvartiraSaleController {
    private final KvartiraSaleView view;

    public KvartiraSaleController(KvartiraSaleView view) {
        this.view = view;

        CRUD<KvartiraSaleSearchParams, KvartiraSaleListDto, KvartiraSaleDto> crud = new CRUD<>(
                view.frame,
                new SearchPanel<>(KvartiraSaleSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.KVARTIRA_SALE_ASYNC
        );
    }

}
