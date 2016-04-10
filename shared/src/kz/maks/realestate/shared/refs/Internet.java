package kz.maks.realestate.shared.refs;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Internet implements HasTitle {
    ADSL("ADSL"),
    TV_CABLE("через TV кабель"),
    PROVODNOY("проводной"),
    OPTIKA("оптика");

    private final String title;

    Internet(String title) {
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

    public static Internet getByTitle(String title) {
        return (Internet) Utils.findByTitle(values(), title);
    }
}
