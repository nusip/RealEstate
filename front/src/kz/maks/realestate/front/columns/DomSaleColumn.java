package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.list.dom.DomSaleListDto;

public enum DomSaleColumn implements IColumn<DomSaleListDto> {
    kolichestvoKomnat("Количество комнат"),
    region("Регион"),
    ulicaDom("Улица/Дом"),
    tipStroyeniya("Тип строения"),
    godPostroyki("Год постройки"),
    cena("Цена"),
    valyuta("Валюта");

    private final String title;

    DomSaleColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<DomSaleListDto> tableClass() {
        return DomSaleListDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
