package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

public interface UserService {

    User get(Long id);

    UserDto get(String identifier, String credentials);

    void delete(Long id);

    UserDto getDto(Long id);

    ListResponse<UserDto> list(UserSearchParams params);

    void save(UserDto userDto);

}
