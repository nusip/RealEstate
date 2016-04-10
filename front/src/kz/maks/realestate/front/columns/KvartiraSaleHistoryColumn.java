package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

public enum KvartiraSaleHistoryColumn implements IColumn<KvartiraSaleDto> {
    kolichestvoKomnat("Количество комнат"),
    dom("Дом"),
    kvartira("Квартира"),
    cena("Цена"),
    cenaProdazhi("Цена продажи"),
    valyuta("Валюта"),
    godPostroyki("Год постройки"),
    tipStroyeniya("Тип строения"),
    isZalog("В залоге"),
    etazh("Этаж"),
    etazhnost("Этажность"),
    ploshadObshaya("Площадь общая"),
    ploshadZhilaya("Площадь жилая"),
    ploshadKuhnya("Площадь кухня"),
    sostoyaniye("Состояние"),
    istochnikInfo("Источник информации"),
    primechanie("Примечание"),
    telefon("Телефон"),
    sanuzel("Санузел"),
    balkon("Балкон"),
    dver("Дверь"),
    pol("Пол"),
    planirovka("Планировка"),
    raznoe("Описание"),
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
