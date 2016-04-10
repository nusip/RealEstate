package kz.maks.realestate.shared.refs.kvartira;

import kz.maks.core.shared.models.HasTitle;
import kz.maks.core.shared.Utils;

public enum TipStroyeniya implements HasTitle {
    KIRPICH("кирпичный"),
    PANEL("панельный"),
    MONOLIT("монолитный"),
    KARKAS_KAMYSH("каркасно-камышитовый"),
    INOE("иное");

    private final String title;

    TipStroyeniya(String title) {
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

    public static TipStroyeniya getByTitle(String title) {
        return (TipStroyeniya) Utils.findByTitle(values(), title);
    }
}
