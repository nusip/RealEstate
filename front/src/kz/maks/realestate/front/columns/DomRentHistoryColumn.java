package kz.maks.realestate.front.columns;

import kz.maks.core.front.annotations.*;
import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

public enum DomRentHistoryColumn implements IColumn<DomRentDto> {
    kolichestvoKomnat("Количество комнат", 110),
    cena("Цена"),
    cenaProdazhi("Цена продажи", 90),
    valyuta("Валюта", 50),
    kakSdayete("Как сдаете", 80),
    tipStroyeniya("Тип строения", 140),
    kolichestvoUrovney("Количество уровней", 120),
    ploshadObshaya("Площадь общая", 100),
    ploshadZhilaya("Площадь жилая", 100),
    ploshadKuhnya("Площадь кухни", 90),
    ploshadUchastka("Площадь участка", 110),
    kakOgorojen("Как огорожен участок", 140),
    sostoyaniye("Состояние", 120),
    istochnikInfo("Источник информации", 170),
    telefon("Телефон", 180),
    internet("Интернет", 90),
    sanuzel("Санузел", 80),
    kanalizaciya("Канализация", 180),
    voda("Вода", 180),
    elektrichestvo("Электричество", 180),
    otopleniye("Отопление", 180),
    gaz("Газ", 180),
    pokrytieKryshi("Покрытие крыши", 120),
    vysotaPotolkov("Высота потолков", 110),
    raznoe("Разное", 250),
    region("Регион", 120),
    dom("Дом", 50),
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

    DomRentHistoryColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    DomRentHistoryColumn(String title, int width) {
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