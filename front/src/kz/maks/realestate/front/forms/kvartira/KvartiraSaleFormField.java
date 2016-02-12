package kz.maks.realestate.front.forms.kvartira;

import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.annotations.Required;
import kz.maks.core.front.annotations.TextArea;
import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;

public enum KvartiraSaleFormField implements FormField<KvartiraSaleGetDto> {
    @Hidden
    id("ID"),
    @Required
    kolichestvoKomnat("Количество комнат"),
    @Required
    cena("Цена"),
    @Required
    valyuta("Валюта"),
    isZalog("В залоге"),
    tipStroyeniya("Тип строения"),
    @Required
    godPostroyki("Год постройки"),
    etazh("Этаж"),
    etazhnost("Этажность"),
    @Required
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
    @Required
    @TreeName("Region")
    regionId("Регион"),
    zhiloyKomplex("ЖК"),
    ulicaDom("Улица/Дом"),
    @Required
    telNumbers("Тел. номер"),
    ;

    private String title;

    KvartiraSaleFormField(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraSaleGetDto> formClass() {
        return KvartiraSaleGetDto.class;
    }
}
