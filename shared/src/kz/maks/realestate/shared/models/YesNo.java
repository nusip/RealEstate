package kz.maks.realestate.shared.models;

import kz.maks.core.shared.models.HasTitle;

public enum YesNo implements HasTitle {
    YES("Да"),
    NO("Нет"),
    NO_MATTER("Не важно");

    private final String title;

    YesNo(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public String title() {
        return title;
    }
}
