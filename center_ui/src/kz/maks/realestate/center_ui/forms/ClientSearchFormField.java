package kz.maks.realestate.center_ui.forms;

import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;

public enum ClientSearchFormField implements FormField<ClientSearchParams> {
    name("Имя/Наименование"),
    isActive("Активный")
    ;

    private final String title;

    ClientSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public Class<ClientSearchParams> formClass() {
        return ClientSearchParams.class;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
