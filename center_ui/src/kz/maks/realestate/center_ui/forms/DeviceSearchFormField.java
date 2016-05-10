package kz.maks.realestate.center_ui.forms;

import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.DeviceSearchParams;

public enum DeviceSearchFormField implements FormField<DeviceSearchParams> {
    clientName("Имя/Наименование клиента"),
    number("МАС устройства"),
    isActive("Активный")
    ;

    private final String title;

    DeviceSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public Class<DeviceSearchParams> formClass() {
        return DeviceSearchParams.class;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
