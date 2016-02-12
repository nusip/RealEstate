package kz.maks.realestate.shared.refs;

import kz.maks.core.shared.models.HasTitle;

public enum Valyuta implements HasTitle {
    TENGE("тг"),
    USD("$"),
    EURO("€"),
    RUBLE("руб");

    private final String title;

    Valyuta(String title) {
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
}
