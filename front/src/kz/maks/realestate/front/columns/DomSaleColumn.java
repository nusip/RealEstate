package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

public enum DomSaleColumn implements IColumn<DomSaleDto> {
    id("ID", 50),
    cena("Цена"),
    valyuta("Валюта", 50),
    isZalog("В залоге", 60),
    kolichestvoKomnat("Количество комнат", 110),
    kolichestvoUrovney("Количество уровней", 120),
    tipStroyeniya("Тип строения", 80),
    ploshadObshaya("Площадь общая", 100),
    ploshadZhilaya("Площадь жилая", 100),
    ploshadKuhnya("Площадь кухни", 90),
    sanuzel("Санузел", 80),
    sostoyaniye("Состояние", 120),
    region("Регион", 120),
    ulica("Улица", 250),
    createdAt("Дата создания", 140),
    ;

    private final String title;
    private final int width;

    DomSaleColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    DomSaleColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<DomSaleDto> tableClass() {
        return DomSaleDto.class;
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
