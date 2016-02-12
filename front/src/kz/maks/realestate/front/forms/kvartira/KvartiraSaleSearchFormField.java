package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.ui.FormField;
import kz.maks.core.front.annotations.TreeName;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

public enum KvartiraSaleSearchFormField implements FormField<KvartiraSaleSearchParams> {
    rooms("Количество комнат"),

    @TreeName("Region")
    regionId("Регион"),

    ;

    private String title;

    KvartiraSaleSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraSaleSearchParams> formClass() {
        return KvartiraSaleSearchParams.class;
    }
}
