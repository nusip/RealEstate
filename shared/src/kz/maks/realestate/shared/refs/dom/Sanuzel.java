package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Sanuzel implements HasTitle {
    RAZDELNY("раздельный"),
    SOVMESHENNY("совмещенный"),
    DVA_I_BOLEE("2 с/у и более"),
    VO_DVORE("во дворе");

    private final String title;

    Sanuzel(String title) {
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

    public static Sanuzel getByTitle(String title) {
        return (Sanuzel) Utils.findByTitle(values(), title);
    }
}
