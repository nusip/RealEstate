package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

public enum DomRentColumn implements IColumn<DomRentDto> {
    cena("Цена"),
    valyuta("Валюта"),
    kolichestvoKomnat("Количество комнат"),
    godPostroyki("Год постройки"),
    etazh("Этаж"),
    etazhnost("Этажность"),
    tipStroyeniya("Тип строения"),
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    sanuzel("Санузел"),
    sostoyaniye("Состояние"),
    region("Регион"),
    ulica("Улица"),
    createdAt("Дата создания"),
    ;

    private final String title;

    DomRentColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<DomRentDto> tableClass() {
        return DomRentDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
