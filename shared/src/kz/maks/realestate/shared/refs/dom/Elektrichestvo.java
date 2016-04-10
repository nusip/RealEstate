package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Elektrichestvo implements HasTitle {
    EST("есть"),
    EST_VOZMOJNOST_PODKL("есть возможность подключения"),
    NET("нет");

    private final String title;

    Elektrichestvo(String title) {
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

    public static Elektrichestvo getByTitle(String title) {
        return (Elektrichestvo) Utils.findByTitle(values(), title);
    }
}
