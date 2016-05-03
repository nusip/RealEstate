package kz.maks.realestate.front.columns;

import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.ui.IColumn;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.UserDto;

public enum UserColumn implements IColumn<UserDto> {
    @Hidden
    id("ID"),
    identifier("Логин"),
    fullName("ФИО"),
    isActive("Активный"),
    roles("Роли"),
    ;

    private final String title;
    private final int width;

    UserColumn(String title) {
        this(title, IColumn.DEFAULT_WIDTH);
    }

    UserColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    @Override
    public Class<UserDto> tableClass() {
        return UserDto.class;
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
