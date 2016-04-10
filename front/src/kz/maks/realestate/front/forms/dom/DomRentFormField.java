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
    valyuta("Валюта"),
    kakSdayete("Как сдаете"),
    tipStroyeniya("Тип строения"),
    kolichestvoUrovney("Количество уровней"),
    @Required
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    ploshadUchastka("Площадь участка"),
    kakOgorojen("Как огорожен участок"),
    sostoyaniye("Состояние"),
    telefon("Телефон"),
    internet("Интернет"),
    sanuzel("Санузел"),
    kanalizaciya("Канализация"),
    voda("Вода"),
    elektrichestvo("Электричество"),
    otopleniye("Отопление"),
    gaz("Газ"),
    pokrytieKryshi("Покрытие крыши"),
    vysotaPotolkov("Высота потолков"),
    @TextArea
    raznoe("Разное"),
    @TreeName("Region")
    @Required
    regionId("Регион"),
    dom("Дом"),
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
