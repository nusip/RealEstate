package kz.maks.realestate.front.forms.dom;

import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

public enum DomRentSearchFormField implements FormField<DomRentSearchParams> {
    rooms("Количество комнат"),

    @TreeName("Region")
    regionId("Регион"),

    ;

    private String title;

    DomRentSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<DomRentSearchParams> formClass() {
        return DomRentSearchParams.class;
    }
}
