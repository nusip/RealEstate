package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Voda implements HasTitle {
    CENTRALNOE_VODOSNABJENIE("центральное водоснабжение"),
    EST_VOZMOJNOST_PODKL("есть возможность подключения"),
    SKVAJINA("скважина"),
    NET("нет");

    private final String title;

    Voda(String title) {
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

    public static Voda getByTitle(String title) {
        return (Voda) Utils.findByTitle(values(), title);
    }
}
