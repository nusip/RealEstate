package kz.maks.realestate.front.forms.dom;

import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

public enum DomRentSearchFormField implements FormField<DomRentSearchParams> {
    dataSozdaniyaFrom("Дата создания"),
    dataSozdaniyaTo("Дата создания"),
    @TreeName("Region")
    regionId("Регион"),
    rooms("Количество комнат"),
    ploshadObshayaMin("Площадь общая"),
    ploshadObshayaMax("Площадь общая"),
    ploshadKuhnyaMin("Площадь кухня"),
    ploshadKuhnyaMax("Площадь кухня"),
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
