package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Sostoyaniye implements HasTitle {
    HOROSHEE("хорошее"),
    SREDNEE("среднее"),
    EVROREMONT("евроремонт"),
    TREBUYET_REMONTA("требует ремонта"),
    SVOBODNAYA_PLANIROVKA("свободная планировка"),
    CHERNOVAYA_OTDELKA("черновая отделка"),
    NEDOSTROENO("недостроено");

    private final String title;

    Sostoyaniye(String title) {
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

    public static Sostoyaniye getByTitle(String title) {
        return (Sostoyaniye) Utils.findByTitle(values(), title);
    }
}
