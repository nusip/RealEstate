package kz.maks.realestate.front.forms.dom;

import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

public enum DomSaleSearchFormField implements FormField<DomSaleSearchParams> {
    dataSozdaniyaFrom("Дата создания"),
    dataSozdaniyaTo("Дата создания"),
    @TreeName("Region")
    regionId("Регион"),
    rooms("Количество комнат"),
    ploshadObshayaMin("Площадь общая"),
    ploshadObshayaMax("Площадь общая"),
    ploshadKuhnyaMin("Площадь кухня"),
    ploshadKuhnyaMax("Площадь кухня"),
    sortField("Сортировать по"),
    sortAsc("по возрастанию"),
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
