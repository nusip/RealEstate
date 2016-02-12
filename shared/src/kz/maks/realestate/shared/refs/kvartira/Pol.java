package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Pol implements HasTitle {
    LINOLEUM("линолеум"),
    PARKET("паркет"),
    LAMINAT("ламинат"),
    DEREVO("дерево"),
    KOVROLAN("ковролан"),
    PLITKA("плитка"),
    PROBKOVOE("пробковое");

    private final String title;

    Pol(String title) {
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

    public static Pol getByTitle(String title) {
        return (Pol) Utils.findByTitle(values(), title);
    }
}
