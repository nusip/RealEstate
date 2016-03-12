package kz.maks.realestate.parser.assemblers.getDto;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.shared.dtos.get.UserDto;

@Bean
public class UserDtoAssembler implements IAssembler<User, UserDto> {

    @Override
    public UserDto assemble(User user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setIdentifier(user.getIdentifier());
        userDto.setFirstName(user.getFirstName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

}
