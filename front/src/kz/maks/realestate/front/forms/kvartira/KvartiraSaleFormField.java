package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.annotations.*;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

public enum KvartiraSaleFormField implements FormField<KvartiraSaleDto> {
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
    isZalog("В залоге"),
    isObwyaga("Общежитие"),
    @Required
    etazh("Этаж"),
    etazhnost("из"),
    @Required
    ploshadObshaya("Площадь, общая"),
    ploshadZhilaya("жилая"),
    ploshadKuhnya("кухня"),
    @ComboName("KvartiraSostoyaniye")
    sostoyaniyeId("Состояние"),
    @ComboName("IstochnikInfo")
    istochnikInfoId("Источник информации"),
    primechanie("Примечание"),
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
    @ComboName("Planirovka")
    planirovkaId("Планировка"),
    @TextArea
    raznoe("Описание"),
    @Required
    @TreeName("Region")
    regionId("Регион"),
    ulica("Улица"),
    peresechenie("Пересечение"),
    @Required
    telNumbers("Тел. номер"),
    @Hidden
    modifiedById("Modified by"),
    isArchive("В архиве"),
    @Disabled
    createdAt("Дата создания"),
    @Disabled
    updatedAt("Дата изменения"),
    @ComboName("User")
    assignedToId("Риэлтор"),
    ;

    private String title;

    KvartiraSaleFormField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<KvartiraSaleDto> formClass() {
        return KvartiraSaleDto.class;
    }
}
