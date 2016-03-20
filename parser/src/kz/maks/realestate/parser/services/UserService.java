package kz.maks.realestate.parser.services;

import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.shared.dtos.UserDto;

public interface UserService {

    User get(Long id);

    UserDto get(String identifier, String credentials);

}
