package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Mebel implements HasTitle {
    PONOSTYU_MEBELIROVANA("полностью меблирована"),
    CHASTICHNO_MEBLIROVANA("частично меблирована"),
    PUSTAYA("пустая");

    private final String title;

    Mebel(String title) {
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

    public static Mebel getByTitle(String title) {
        return (Mebel) Utils.findByTitle(values(), title);
    }
}
