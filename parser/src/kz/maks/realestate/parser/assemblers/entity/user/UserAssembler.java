package kz.maks.realestate.parser.assemblers.entity.user;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.shared.PasswordUtils;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.shared.dtos.UserDto;

import static kz.maks.core.shared.PasswordUtils.getPasswordHash;

@Bean
public class UserAssembler implements IAssembler<UserDto, User> {

    @Override
    public User assemble(UserDto userDto, User user) {
        user.setId(userDto.getId());
        user.setIdentifier(userDto.getIdentifier());
        user.setCredentials(getPasswordHash(userDto.getCredentials()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMiddleName(userDto.getMiddleName());
        user.setIsActive(userDto.isActive());
//        user.setRoles();
        // TODO
        return user;
    }

}
