package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

public enum KvartiraRentSearchFormField implements FormField<KvartiraRentSearchParams> {
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
    vArhive("В архиве"),
    sortField("Сортировать по"),
    sortAsc("по возрастанию"),
    ;

    private String title;

    KvartiraRentSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<KvartiraRentSearchParams> formClass() {
        return KvartiraRentSearchParams.class;
    }
}
