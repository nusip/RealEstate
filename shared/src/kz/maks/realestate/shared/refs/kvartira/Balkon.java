package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Balkon implements HasTitle {
    BALKON("балкон"),
    LODJIYA("лоджия"),
    BALKON_I_LODJIYA("балкон и лоджия"),
    NESKOLKO_BALKONOV_ILI_LODJIY("несколько балконов или лоджий");

    private final String title;

    Balkon(String title) {
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

    public static Balkon getByTitle(String title) {
        return (Balkon) Utils.findByTitle(values(), title);
    }
}
