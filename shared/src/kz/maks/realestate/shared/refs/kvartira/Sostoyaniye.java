package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Sostoyaniye implements HasTitle {
    HOROSHEE("хорошее"),
    SREDNEE("среднее"),
    EVROREMONT("евроремонт"),
    TREBUYET_REMONTA("требует ремонта"),
    SVOBODNAYA_PLANIROVKA("свободная планировка"),
    CHERNOVAYA_OTDELKA("черновая отделка");

    private final String title;

    Sostoyaniye(String title) {
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

    public static Sostoyaniye getByTitle(String title) {
        return (Sostoyaniye) Utils.findByTitle(values(), title);
    }
}
