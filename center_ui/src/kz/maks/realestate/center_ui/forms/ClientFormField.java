package kz.maks.realestate.center_ui.forms;

import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.annotations.Required;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.ClientDto;

public enum ClientFormField implements FormField<ClientDto> {
    @Hidden
    id("id"),
    @Required
    name("Имя/Наименование"),
    isActive("Активный"),
    ;

    private final String title;

    ClientFormField(String title) {
        this.title = title;
    }

    @Override
    public Class<ClientDto> formClass() {
        return ClientDto.class;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
