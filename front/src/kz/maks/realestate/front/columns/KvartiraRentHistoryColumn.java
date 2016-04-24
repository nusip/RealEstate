package kz.maks.realestate.front.columns;

import kz.maks.core.front.annotations.*;
import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

public enum KvartiraRentHistoryColumn implements IColumn<KvartiraRentDto> {
    kolichestvoKomnat("Количество комнат"),
    dom("Дом"),
    kvartira("Квартира"),
    cena("Цена"),
    cenaProdazhi("Цена продажи"),
    valyuta("Валюта"),
    godPostroyki("Год постройки"),
    tipStroyeniya("Тип строения"),
    kakSdayete("Как сдаете"),
    etazh("Этаж"),
    etazhnost("Этажность"),
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    sostoyaniye("Состояние"),
    istochnikInfo("Источник информации"),
    telefon("Телефон"),
    sanuzel("Санузел"),
    balkon("Балкон"),
    dver("Дверь"),
    pol("Пол"),
    raznoe("Разное"),
    region("Регион"),
    ulica("Улица"),
    peresechenie("Пересечение"),
    telNumbers("Тел. номер"),
    assignedTo("Риэлтор"),
    isArchive("В архиве"),
    createdAt("Дата создания"),
    updatedAt("Дата изменения"),
    modifiedBy("Автор изменения"),
    ;

    private final String title;
    private final int width;

    KvartiraRentHistoryColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    KvartiraRentHistoryColumn(String title, int width) {
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