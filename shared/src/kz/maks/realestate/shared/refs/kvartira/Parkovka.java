package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Parkovka implements HasTitle {
    PARKING("паркинг"),
    GARAZH("гараж"),
    RYADOM_OHRANYAEMAYA_STOYANKA("рядом охраняемая стоянка");

    private final String title;

    Parkovka(String title) {
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

    public static Parkovka getByTitle(String title) {
        return (Parkovka) Utils.findByTitle(values(), title);
    }
}
