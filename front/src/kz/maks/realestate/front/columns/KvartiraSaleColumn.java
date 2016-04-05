package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

public enum KvartiraSaleColumn implements IColumn<KvartiraSaleDto> {
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
    balkon("Балкон"),
    planirovka("Планировка"),
    sanuzel("Санузел"),
    sostoyaniye("Состояние"),
    region("Регион"),
    ulica("Улица"),
    createdAt("Дата создания"),
    ;

    private final String title;

    KvartiraSaleColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraSaleDto> tableClass() {
        return KvartiraSaleDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
