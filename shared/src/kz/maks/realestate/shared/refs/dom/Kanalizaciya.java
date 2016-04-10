package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Kanalizaciya implements HasTitle {
    CENTRALNAYA("центральная"),
    EST_VOZMOJNOST_PODVEDENIYA("есть возможность подведения"),
    SEPTIK("септик"),
    NET("нет");

    private final String title;

    Kanalizaciya(String title) {
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

    public static Kanalizaciya getByTitle(String title) {
        return (Kanalizaciya) Utils.findByTitle(values(), title);
    }
}
