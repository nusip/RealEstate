package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

public enum KvartiraRentSearchFormField implements FormField<KvartiraRentSearchParams> {
    rooms("Количество комнат"),

    @TreeName("Region")
    regionId("Регион"),

    ;

    private String title;

    KvartiraRentSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraRentSearchParams> formClass() {
        return KvartiraRentSearchParams.class;
    }
}
