package kz.maks.realestate.front.columns;

import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.front.ui.kvartira.KvartiraSalePhoneRecord;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

public enum KvartiraSalePhoneColumn implements IColumn<KvartiraSalePhoneRecord> {
    number("<HTML>Тел. номер<b color=\"red\">*</b></HTML>")
    ;

    private final String title;

    KvartiraSalePhoneColumn(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Class<KvartiraSalePhoneRecord> tableClass() {
        return KvartiraSalePhoneRecord.class;
    }

    @Override
    public String toString() {
        return title;
    }
}
