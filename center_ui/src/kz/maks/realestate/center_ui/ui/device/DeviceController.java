package kz.maks.realestate.center_ui.ui.device;

import kz.maks.core.front.ui.CRUD;
import kz.maks.core.front.ui.SearchPanel;
import kz.maks.realestate.center_ui.services.asyncs.Asyncs;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;

public class DeviceController {

    public DeviceController(DeviceView view) {
        new CRUD<>(
                view.rootFrame,
                new SearchPanel<>(DeviceSearchParams.class, view.searchForm, view.searchForm.btnSearch),
                view.table,
                view.btnPgPanel,
                view.btnCRUDPanel,
                view.formDialog,
                Asyncs.DEVICE_ASYNC
        );
    }

}
