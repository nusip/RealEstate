package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum Otopleniye implements HasTitle {
    CENTRALNOE("центральное"),
    NA_GAZE("на газе"),
    NA_TVERDOM_TOPLIVE("на твердом топливе"),
    NA_JIDKOM_TOPLIVE("на жидком топливе"),
    SMESHANNOE("смешанное"),
    BEZ_OTOPLENIYA("без отопления");

    private final String title;

    Otopleniye(String title) {
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

    public static Otopleniye getByTitle(String title) {
        return (Otopleniye) Utils.findByTitle(values(), title);
    }
}
