package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.ui.FormField;
import kz.maks.core.front.annotations.TreeName;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

public enum KvartiraSaleSearchFormField implements FormField<KvartiraSaleSearchParams> {
    dataSozdaniyaFrom("Дата создания"),
    dataSozdaniyaTo("Дата создания"),
    @TreeName("Region")
    regionId("Регион"),
    rooms("Количество комнат"),
    etazhMin("Этаж"),
    etazhMax("Этаж"),
    etazhnostMin("Этажность"),
    etazhnostMax("Этажность"),
    ploshadObshayaMin("Площадь общая"),
    ploshadObshayaMax("Площадь общая"),
    ploshadKuhnyaMin("Площадь кухня"),
    ploshadKuhnyaMax("Площадь кухня"),
    obwyaga("Общежитие"),
    sortField("Сортировать по"),
    sortAsc("по возрастанию"),
    ;

    private String title;

    KvartiraSaleSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<KvartiraSaleSearchParams> formClass() {
        return KvartiraSaleSearchParams.class;
    }
}
