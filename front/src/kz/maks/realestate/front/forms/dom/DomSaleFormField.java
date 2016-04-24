package kz.maks.realestate.front.forms.dom;

import kz.maks.core.front.annotations.*;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

public enum DomSaleFormField implements FormField<DomSaleDto> {
    @Hidden
    id("id"),
    @Required
    kolichestvoKomnat("Количество комнат"),
    @Required
    cena("Цена"),
    cenaProdazhi("Цена продажи"),
    @Required
    @ComboName("Valyuta")
    valyutaId("Валюта"),
    isZalog("В залоге"),
    @ComboName("DomTipStroyeniya")
    tipStroyeniyaId("Тип строения"),
    kolichestvoUrovney("Количество уровней"),
    @Required
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    ploshadUchastka("Площадь участка"),
    kakOgorojen("Как огорожен участок"),
    @ComboName("DomSostoyaniye")
    sostoyaniyeId("Состояние"),
    @ComboName("DomTelefon")
    telefonId("Телефон"),
    @ComboName("Internet")
    internetId("Интернет"),
    @ComboName("DomSanuzel")
    sanuzelId("Санузел"),
    @ComboName("Kanalizaciya")
    kanalizaciyaId("Канализация"),
    @ComboName("Voda")
    vodaId("Вода"),
    @ComboName("Elektrichestvo")
    elektrichestvoId("Электричество"),
    @ComboName("Otopleniye")
    otopleniyeId("Отопление"),
    @ComboName("Gaz")
    gazId("Газ"),
    pokrytieKryshi("Покрытие крыши"),
    vysotaPotolkov("Высота потолков"),
    @TextArea
    raznoe("Разное"),
    @Required
    @TreeName("Region")
    regionId("Регион"),
    dom("Дом"),
    ulica("Улица"),
    peresechenie("Пересечение"),
    @Required
    telNumbers("Тел. номер"),
    @ComboName("User")
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

    DomSaleFormField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<DomSaleDto> formClass() {
        return DomSaleDto.class;
    }
}
