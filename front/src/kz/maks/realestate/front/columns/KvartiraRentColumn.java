package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

public enum KvartiraRentColumn implements IColumn<KvartiraRentDto> {
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
    balkon("Балкон"),
    planirovka("Планировка"),
    sanuzel("Санузел"),
    sostoyaniye("Состояние"),
    region("Регион"),
    ulica("Улица"),
    createdAt("Дата создания"),
    ;

    private final String title;

    KvartiraRentColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraRentDto> tableClass() {
        return KvartiraRentDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
