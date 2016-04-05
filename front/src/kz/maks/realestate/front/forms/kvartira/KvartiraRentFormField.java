package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.annotations.*;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

public enum KvartiraRentFormField implements FormField<KvartiraRentDto> {
    @Hidden
    id("ID"),
    @Required
    kolichestvoKomnat("Количество комнат"),
    dom("Дом"),
    kvartira("Квартира"),
    @Required
    cena("Цена"),
    cenaProdazhi("Цена продажи"),
    @Required
    valyuta("Валюта"),
    godPostroyki("Год постройки"),
    tipStroyeniya("Тип строения"),
    kakSdayete("Как сдаете"),
    @Required
    etazh("Этаж"),
    etazhnost("Этажность"),
    @Required
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    sostoyaniye("Состояние"),
    istochnikInfo("Источник информации"),
    telefon("Телефон"),
    sanuzel("Санузел"),
    balkon("Балкон"),
    dver("Дверь"),
    pol("Пол"),
    @TextArea
    raznoe("Разное"),
    @Required
    @TreeName("Region")
    regionId("Регион"),
    ulica("Улица"),
    peresechenie("Пересечение"),
    @Required
    telNumbers("Тел. номер"),
    assignedToId("Риэлтор"),
    @Hidden
    modifiedById("Modified by"),
    isArchive("В архиве"),
    @Disabled
    createdAt("Дата создания"),
    @Disabled
    updatedAt("Дата изменения"),
    ;

    private String title;

    KvartiraRentFormField(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraRentDto> formClass() {
        return KvartiraRentDto.class;
    }

}
