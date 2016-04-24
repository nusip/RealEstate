package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

public enum DomSaleHistoryColumn implements IColumn<DomSaleDto> {
    kolichestvoKomnat("Количество комнат"),
    cena("Цена"),
    cenaProdazhi("Цена продажи"),
    valyuta("Валюта"),
    isZalog("В залоге"),
    tipStroyeniya("Тип строения"),
    kolichestvoUrovney("Количество уровней"),
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухни"),
    ploshadUchastka("Площадь участка"),
    kakOgorojen("Как огорожен участок"),
    sostoyaniye("Состояние"),
    istochnikInfo("Источник информации"),
    telefon("Телефон"),
    internet("Интернет"),
    sanuzel("Санузел"),
    kanalizaciya("Канализация"),
    voda("Вода"),
    elektrichestvo("Электричество"),
    otopleniye("Отопление"),
    gaz("Газ"),
    pokrytieKryshi("Покрытие крыши"),
    vysotaPotolkov("Высота потолков"),
    raznoe("Разное"),
    region("Регион"),
    dom("Дом"),
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

    DomSaleHistoryColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    DomSaleHistoryColumn(String title, int width) {
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