package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Gaz implements HasTitle {
    MAGISTRALNY("магистральный"),
    AVTONOMNY("автономный"),
    EST_VOZMOJNOST_PODKL("есть возможность подключения"),
    NET("нет");

    private final String title;

    Gaz(String title) {
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

    public static Gaz getByTitle(String title) {
        return (Gaz) Utils.findByTitle(values(), title);
    }
}
