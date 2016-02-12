package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.annotations.TextArea;
import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;

public enum KvartiraRentFormField implements FormField<KvartiraRentGetDto> {
    @Hidden
    id("ID"),

    kolichestvoKomnat("Количество комнат"),
    cena("Цена"),
    valyuta("Валюта"),
    kakSdayete("Как сдаете"),
    tipStroyeniya("Тип строения"),
    godPostroyki("Год постройки"),
    etazh("Этаж"),
    etazhnost("Этажность"),
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    isObwyaga("В прив. общежитии"),
    sostoyaniye("Состояние"),
    telefon("Телефон"),
    internet("Интернет"),
    sanuzel("Санузел"),
    balkon("Балкон"),
    dver("Дверь"),
    parkovka("Парковка"),
    mebel("Мебель"),
    pol("Пол"),
    vysotaPotolkov("Высота потолков"),
    reshetkiNaOknah("Решетки на окнах"),
    signalizaciya("Сигнализация"),
    ohrana("Охрана"),
    videonablyudeniye("Видеонаблюдение"),
    domofon("Домофон"),
    videomofon("Видеомофон"),
    kodovyZamok("Кодовый замок"),
    konsyerzh("Консьерж"),
    @TextArea
    raznoe("Разное"),
//    photoPaths("Фото"), TODO
    @TreeName("Region")
    regionId("Регион"),
    zhiloyKomplex("ЖК"),
    ulicaDom("Улица/Дом"),
    telNumbers("Тел. номер"),
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
    public Class<KvartiraRentGetDto> formClass() {
        return KvartiraRentGetDto.class;
    }

}
