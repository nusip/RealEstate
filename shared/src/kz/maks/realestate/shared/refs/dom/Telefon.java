package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Telefon implements HasTitle {
    EST("есть"),
    EST_VOZMOJNOST_PODKL("есть возможность подключения"),
    NET("нет");

    private final String title;

    Telefon(String title) {
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

    public static Telefon getByTitle(String title) {
        return (Telefon) Utils.findByTitle(values(), title);
    }
}
