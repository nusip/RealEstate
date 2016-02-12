package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;

public enum KvartiraSaleColumn implements IColumn<KvartiraSaleListDto> {
    kolichestvoKomnat("Количество комнат"),
    region("Регион"),
    zhiloyKomplex("ЖК"),
    ulicaDom("Улица/Дом"),
    tipStroyeniya("Тип строения"),
    godPostroyki("Год постройки"),
    cena("Цена"),
    valyuta("Валюта");

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
