package kz.maks.realestate.front.forms.users;

import kz.maks.core.front.annotations.ComboName;
import kz.maks.core.front.annotations.Hidden;
import kz.maks.core.front.annotations.Password;
import kz.maks.core.front.annotations.Required;
import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

public enum UserFormField implements FormField<UserDto> {
    @Hidden
    id("id"),
    @Required
    identifier("Логин"),
    @Password
    credentials("Пароль"),
    @Required
    firstName("Имя"),
    lastName("Фамилия"),
    middleName("Отчество"),
    isActive("Активный"),
    @ComboName("Role")
    roleIds("Роли"),
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
