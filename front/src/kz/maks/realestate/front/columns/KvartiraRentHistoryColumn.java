package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

public enum KvartiraRentHistoryColumn implements IColumn<KvartiraRentDto> {
    kolichestvoKomnat("Количество комнат", 110),
    dom("Дом", 50),
    kvartira("Квартира", 60),
    cena("Цена"),
    cenaProdazhi("Цена продажи", 90),
    valyuta("Валюта", 50),
    godPostroyki("Год постройки", 90),
    tipStroyeniya("Тип строения", 140),
    kakSdayete("Как сдаете", 80),
    etazh("Этаж", 40),
    etazhnost("Этажность", 70),
    ploshadObshaya("Площадь общая", 100),
    ploshadZhilaya("Площадь жилая", 100),
    ploshadKuhnya("Площадь кухни", 90),
    sostoyaniye("Состояние", 120),
    istochnikInfo("Источник информации", 170),
    telefon("Телефон", 180),
    sanuzel("Санузел", 80),
    balkon("Балкон", 170),
    dver("Дверь", 90),
    pol("Пол"),
    planirovka("Планировка", 90),
    raznoe("Разное", 250),
    region("Регион", 120),
    ulica("Улица", 250),
    peresechenie("Пересечение", 150),
    telNumbers("Тел. номер", 110),
    assignedTo("Риэлтор", 150),
    isArchive("В архиве", 60),
    createdAt("Дата создания", 140),
    updatedAt("Дата изменения", 140),
    modifiedBy("Автор изменения", 150),
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