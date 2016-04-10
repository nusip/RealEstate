package kz.maks.realestate.shared.refs;

import kz.maks.core.shared.Utils;
import kz.maks.core.shared.models.HasTitle;

public enum IstochnikInfo implements HasTitle {
    KRISHA("крыша"),
    IZ_RUK_V_RUKI("из рук в руки"),
    NEDVIJIMOST_BEZ_POSREDNIKOV("недвижимость без посредников"),
    GAZETA("газета");

    private final String title;

    IstochnikInfo(String title) {
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

    public static IstochnikInfo getByTitle(String title) {
        return (IstochnikInfo) Utils.findByTitle(values(), title);
    }
}
