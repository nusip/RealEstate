package kz.maks.realestate.shared.refs.dom;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum TipStroyeniya implements HasTitle {
    KIRPICH("кирпичный"),
    PANEL("панельный"),
    MONOLIT("монолитный"),
    DEREVO("деревянный"),
    KARKAS_KAMYSH("каркасно-камышитовый"),
    PENOBLOK("пеноблочный"),
    SANDVICH_PANEL("сэндвич-панели"),
    KARKAS_SHIT("каркасно-щитовой"),
    SHLAKOBLOK("шлакоблочный"),
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
