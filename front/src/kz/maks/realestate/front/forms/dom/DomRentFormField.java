package kz.maks.realestate.front.forms.dom;

import kz.maks.core.front.annotations.*;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

public enum DomRentFormField implements FormField<DomRentDto> {
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
    @ComboName("KakSdayete")
    kakSdayeteId("Как сдаете"),
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
    @ComboName("IstochnikInfo")
    istochnikInfoId("Источник информации"),
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
    primechanie("Примечание"),
    @Required
    telNumbers("Тел. номер"),
    @TreeName("Region")
    @Required
    regionId("Регион"),
    dom("Дом"),
    ulica("Улица"),
    peresechenie("Пересечение"),
    @Disabled
    createdAt("Дата создания"),
    @Disabled
    updatedAt("Дата изменения"),
    @ComboName("User")
    assignedToId("Риэлтор"),
    @Hidden
    modifiedById("Modified by"),
    isArchive("В архиве"),
    ;

    private String title;

    DomRentFormField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<DomRentDto> formClass() {
        return DomRentDto.class;
    }

}
