package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Dver implements HasTitle {
    DEREVYANNAYA("деревянная"),
    METALICHESKAYA("металлическая"),
    BRONIROVANNAYA("бронированная");

    private final String title;

    Dver(String title) {
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

    public static Dver getByTitle(String title) {
        return (Dver) Utils.findByTitle(values(), title);
    }
}
