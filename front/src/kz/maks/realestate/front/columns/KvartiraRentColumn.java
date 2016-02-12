package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraRentListDto;

public enum KvartiraRentColumn implements IColumn<KvartiraRentListDto> {
    kolichestvoKomnat("Количество комнат"),
    region("Регион"),
    zhiloyKomplex("ЖК"),
    ulicaDom("Улица/Дом"),
    tipStroyeniya("Тип строения"),
    godPostroyki("Год постройки"),
    cena("Цена"),
    valyuta("Валюта");

    private final String title;

    KvartiraRentColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraRentListDto> tableClass() {
        return KvartiraRentListDto.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
