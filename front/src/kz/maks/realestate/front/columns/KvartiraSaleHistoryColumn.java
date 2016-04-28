package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

public enum KvartiraSaleHistoryColumn implements IColumn<KvartiraSaleDto> {
    kolichestvoKomnat("Количество комнат", 110),
    dom("Дом", 50),
    kvartira("Квартира", 60),
    cena("Цена"),
    cenaProdazhi("Цена продажи", 90),
    valyuta("Валюта", 50),
    godPostroyki("Год постройки", 90),
    tipStroyeniya("Тип строения", 140),
    isZalog("В залоге", 60),
    etazh("Этаж", 40),
    etazhnost("Этажность", 70),
    ploshadObshaya("Площадь общая", 100),
    ploshadZhilaya("Площадь жилая", 100),
    ploshadKuhnya("Площадь кухня", 90),
    sostoyaniye("Состояние", 120),
    istochnikInfo("Источник информации", 170),
    primechanie("Примечание", 170),
    telefon("Телефон", 180),
    sanuzel("Санузел", 80),
    balkon("Балкон", 170),
    dver("Дверь", 90),
    pol("Пол"),
    planirovka("Планировка", 90),
    raznoe("Описание", 250),
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

    KvartiraSaleHistoryColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    KvartiraSaleHistoryColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Class<KvartiraSaleDto> tableClass() {
        return KvartiraSaleDto.class;
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
