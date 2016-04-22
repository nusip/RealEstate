package kz.maks.realestate.front.ui;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum SortField implements HasTitle {
    createdAt("дате создания"),
    cena("цене"),
    kolichestvoKomnat("количеству комнат"),
    ;

    private final String title;

    SortField(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static SortField getByTitle(String title) {
        return (SortField) Utils.findByTitle(values(), title);
    }
}
