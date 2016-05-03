package kz.maks.realestate.parser.assemblers.dto;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.shared.dtos.UserDto;

import static kz.maks.core.shared.Utils.extractName;
import static kz.maks.core.shared.Utils.extractNames;

@Bean
public class UserDtoAssembler implements IAssembler<User, UserDto> {

    @Override
    public UserDto assemble(User user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setIdentifier(user.getIdentifier());
        userDto.setFirstName(user.getFirstName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setLastName(user.getLastName());
        userDto.setRoles(extractNames(user.getRoles()));
        return userDto;
    }

}
