package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.annotations.*;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

public enum KvartiraRentFormField implements FormField<KvartiraRentDto> {
    @Hidden
    id("id"),
    @Required
    kolichestvoKomnat("Количество комнат"),
    dom("Дом"),
    kvartira("Квартира"),
    @Required
    cena("Цена"),
    cenaProdazhi("Цена продажи"),
    @Required
    @ComboName("Valyuta")
    valyutaId("Валюта"),
    godPostroyki("Год постройки"),
    @ComboName("KvartiraTipStroyeniya")
    tipStroyeniyaId("Тип строения"),
    @ComboName("KakSdayete")
    kakSdayeteId("Как сдаете"),
    @Required
    etazh("Этаж"),
    etazhnost("Этажность"),
    @Required
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    @ComboName("KvartiraSostoyaniye")
    sostoyaniyeId("Состояние"),
    @ComboName("IstochnikInfo")
    istochnikInfoId("Источник информации"),
    @ComboName("KvartiraTelefon")
    telefonId("Телефон"),
    @ComboName("KvartiraSanuzel")
    sanuzelId("Санузел"),
    @ComboName("Balkon")
    balkonId("Балкон"),
    @ComboName("Dver")
    dverId("Дверь"),
    @ComboName("Pol")
    polId("Пол"),
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
    public String getTitle() {
        return title;
    }

    @Override
    public Class<KvartiraRentDto> formClass() {
        return KvartiraRentDto.class;
    }

}
