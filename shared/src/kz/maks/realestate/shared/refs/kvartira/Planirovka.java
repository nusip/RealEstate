package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Planirovka implements HasTitle {
    IZOLIROVANNYE("изолированные"),
    SMEJNYE("смежные"),
    DVA_PLUS_ODIN("2+1");

    private final String title;

    Planirovka(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static Planirovka getByTitle(String title) {
        return (Planirovka) Utils.findByTitle(values(), title);
    }
}
