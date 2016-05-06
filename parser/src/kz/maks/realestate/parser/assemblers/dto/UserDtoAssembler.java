package kz.maks.realestate.parser.assemblers.dto;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.shared.dtos.UserDto;

import static kz.maks.core.shared.Utils.*;

@Bean
public class UserDtoAssembler implements IAssembler<User, UserDto> {

    @Override
    public UserDto assemble(User user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setIdentifier(user.getIdentifier());
        userDto.setFirstName(user.getFirstName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setLastName(user.getLastName());
        userDto.setFullName(user.getFullName());
        userDto.setIsActive(user.isActive());
        userDto.setRoleIds(extractIds(user.getRoles()));
        userDto.setRoleNames(extractNames(user.getRoles()));
        userDto.setRoleTitles(extractTitles(user.getRoles()));
        return userDto;
    }

}
