package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.Callback;
import kz.maks.realestate.shared.dtos.get.UserDto;

public interface UserAsync {

    void get(String identifier, String credentials, Callback<UserDto> callback);

}
