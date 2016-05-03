package kz.maks.realestate.front.forms.users;

import kz.maks.core.front.ui.FormField;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

public enum UserSearchFormField implements FormField<UserSearchParams> {
    identifier("Логин"),
    firstName("Имя"),
    isActive("Активный")
    ;

    private final String title;

    UserSearchFormField(String title) {
        this.title = title;
    }

    @Override
    public Class<UserSearchParams> formClass() {
        return UserSearchParams.class;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
