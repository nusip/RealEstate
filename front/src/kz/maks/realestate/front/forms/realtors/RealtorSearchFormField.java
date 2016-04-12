package kz.maks.realestate.front.forms.realtors;

import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

public enum RealtorSearchFormField implements FormField<RealtorSearchParams> {
    name("Имя"),
    company("Компания"),
    telNumber("Тел. номер")
    ;

    private final String title;

    RealtorSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public Class<RealtorSearchParams> formClass() {
        return RealtorSearchParams.class;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
