package kz.maks.realestate.center_ui.forms;

import kz.maks.core.front.annotations.ComboName;
import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.annotations.Required;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.DeviceDto;

public enum DeviceFormField implements FormField<DeviceDto> {
    @Hidden
    id("id"),
    @ComboName("Client")
    clientId("Клиент"),
    @Required
    number("МАС устройства"),
    isActive("Активный"),
    ;

    private final String title;

    DeviceFormField(String title) {
        this.title = title;
    }

    @Override
    public Class<DeviceDto> formClass() {
        return DeviceDto.class;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
