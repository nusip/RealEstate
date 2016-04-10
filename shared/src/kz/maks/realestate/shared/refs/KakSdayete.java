package kz.maks.realestate.shared.refs;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum KakSdayete implements HasTitle {
    PO_CHASAM("по часам"),
    POSUTOCHNO("посуточно"),
    POMESYACHNO("помесячно"),
    POKVARTALNO("поквартально");

    private final String title;

    KakSdayete(String title) {
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

    public static KakSdayete getByTitle(String title) {
        return (KakSdayete) Utils.findByTitle(values(), title);
    }
}
