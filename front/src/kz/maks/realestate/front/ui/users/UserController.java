package kz.maks.realestate.front.ui.users;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.front.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

public class UserController {
    private final UserView view;

    public UserController(UserView view) {
        this.view = view;

        new CRUD<>(
                view.rootFrame,
                new SearchPanel<>(UserSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.USER_ASYNC
        );

    }

}
