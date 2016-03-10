package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;

public enum KvartiraSaleColumn implements IColumn<KvartiraSaleListDto> {
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
    public Class<KvartiraSaleListDto> tableClass() {
        return KvartiraSaleListDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
