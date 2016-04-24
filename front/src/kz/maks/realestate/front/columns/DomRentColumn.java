package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

public enum DomRentColumn implements IColumn<DomRentDto> {
    id("ID", 0),
    cena("Цена"),
    valyuta("Валюта"),
    kolichestvoKomnat("Количество комнат"),
    kolichestvoUrovney("Количество уровней"),
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
    private final int width;

    DomRentColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    DomRentColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<DomRentDto> tableClass() {
        return DomRentDto.class;
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    public int width() {
        return width;
    }


    @Override
    public String toString() {
        return title;
    }
}
