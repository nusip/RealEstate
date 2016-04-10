package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

public enum KvartiraRentColumn implements IColumn<KvartiraRentDto> {
    id("ID", 0),
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
    private final int width;

    KvartiraRentColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    KvartiraRentColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<KvartiraRentDto> tableClass() {
        return KvartiraRentDto.class;
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
