package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum Telefon implements HasTitle {
    OTDELNY("отдельный"),
    BLOKIRATOR("блокиратор"),
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
