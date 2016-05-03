package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

public interface UserAsync extends ICRUDAsync<UserSearchParams, UserDto, UserDto> {

    void get(String identifier, String credentials, Callback<UserDto> callback);

}
