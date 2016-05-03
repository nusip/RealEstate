package kz.maks.realestate.front.forms.users;

import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

public enum UserFormField implements FormField<UserDto> {
    identifier("Логин"),
    credentials("Логин"),
    firstName("Имя"),
    lastName("Имя"),
    middleName("Имя"),
    isActive("Активный"),
    roles("Роли"),
    ;

    private final String title;

    UserFormField(String title) {
        this.title = title;
    }

    @Override
    public Class<UserDto> formClass() {
        return UserDto.class;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
