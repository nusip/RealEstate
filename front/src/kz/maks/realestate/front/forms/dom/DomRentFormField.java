package kz.maks.realestate.front.forms.dom;

import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.annotations.TextArea;
import kz.maks.core.front.annotations.TreeName;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;

public enum DomRentFormField implements FormField<DomRentGetDto> {
    @Hidden
    id("ID"),

    kolichestvoKomnat("Количество комнат"),
    cena("Цена"),
    valyuta("Валюта"),
    kakSdayete("Как сдаете"),
    tipStroyeniya("Тип строения"),
    kolichestvoUrovney("Количество уровней"),
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
    reshetkiNaOknah("Решетки на окнах"),
    domofon("Домофон"),
    signalizaciya("Сигнализация"),
    videomofon("Видеомофон"),
    videonablyudeniye("Видеонаблюдение"),
    kruglosutochnayaOhrana("Круглосуточная охрана"),
    @TextArea
    raznoe("Разное"),
//    photoPaths("Фото"), TODO
    @TreeName("Region")
    regionId("Регион"),
    ulicaDom("Улица/Дом"),
    telNumbers("Тел. номер"),
    ;

    private String title;

    DomRentFormField(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<DomRentGetDto> formClass() {
        return DomRentGetDto.class;
    }

}
