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
    dom("Дом"),
    kvartira("Квартира"),
    @Required
    cena("Цена"),
    cenaProdazhi("Цена продажи"),
    @Required
    valyuta("Валюта"),
    godPostroyki("Год постройки"),
    tipStroyeniya("Тип строения"),
    isZalog("В залоге"),
    @Required
    etazh("Этаж"),
    etazhnost("из"),
    @Required
    ploshadObshaya("Площадь, общая"),
    ploshadZhilaya("жилая"),
    ploshadKuhnya("кухня"),
//    isObwyaga("В прив. общежитии"),
    sostoyaniye("Состояние"),
    istochnikInfo("Источник информации"),
    primechanie("Примечание"),
    telefon("Телефон"),
//    internet("Интернет"),
    sanuzel("Санузел"),
    balkon("Балкон"),
    dver("Дверь"),
//    parkovka("Парковка"),
//    mebel("Мебель"),
    pol("Пол"),
    planirovka("Планировка"),
    isArchive("В архиве"),
    createdAt("Дата создания"),
    updatedAt("Дата изменения"),
    assignedToId("Риэлтор"),
//    vysotaPotolkov("Высота потолков"),
//    reshetkiNaOknah("Решетки на окнах"),
//    signalizaciya("Сигнализация"),
//    ohrana("Охрана"),
//    videonablyudeniye("Видеонаблюдение"),
//    domofon("Домофон"),
//    videomofon("Видеомофон"),
//    kodovyZamok("Кодовый замок"),
//    konsyerzh("Консьерж"),
//    @TextArea
    raznoe("Описание"),
////    photoPaths("Фото"), TODO
    @Required
    @TreeName("Region")
    regionId("Регион"),
//    zhiloyKomplex("ЖК"),
    ulica("Улица"),
    peresechenie("Пересечение"),
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
