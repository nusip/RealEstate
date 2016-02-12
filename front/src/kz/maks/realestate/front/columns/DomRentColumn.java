package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;

public enum DomRentColumn implements IColumn<DomRentListDto> {
    kolichestvoKomnat("Количество комнат"),
    region("Регион"),
    ulicaDom("Улица/Дом"),
    tipStroyeniya("Тип строения"),
    godPostroyki("Год постройки"),
    cena("Цена"),
    valyuta("Валюта");

    private final String title;

    DomRentColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<DomRentListDto> tableClass() {
        return DomRentListDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
