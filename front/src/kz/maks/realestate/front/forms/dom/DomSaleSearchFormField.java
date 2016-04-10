package kz.maks.realestate.front.forms.dom;

import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

public enum DomSaleSearchFormField implements FormField<DomSaleSearchParams> {
    rooms("Количество комнат"),

    @TreeName("Region")
    regionId("Регион"),

    ;

    private String title;

    DomSaleSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<DomSaleSearchParams> formClass() {
        return DomSaleSearchParams.class;
    }
}
