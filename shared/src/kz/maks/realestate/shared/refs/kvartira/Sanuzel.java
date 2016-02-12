package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Sanuzel implements HasTitle {
    RAZDELNY("раздельный"),
    SOVMESHENNY("совмещенный"),
    DVA_I_BOLEE("2 с/у и более"),
    NET("нет");

    private final String title;

    Sanuzel(String title) {
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

    public static Sanuzel getByTitle(String title) {
        return (Sanuzel) Utils.findByTitle(values(), title);
    }
}
