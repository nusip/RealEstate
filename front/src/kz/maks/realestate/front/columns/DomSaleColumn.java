package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

public enum DomSaleColumn implements IColumn<DomSaleDto> {
    cena("Цена"),
    valyuta("Валюта"),
    isZalog("В залоге"),
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

    DomSaleColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<DomSaleDto> tableClass() {
        return DomSaleDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
