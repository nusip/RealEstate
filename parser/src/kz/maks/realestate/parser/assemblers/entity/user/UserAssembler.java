package kz.maks.realestate.parser.assemblers.entity.user;

import com.google.common.base.Strings;
import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.back.entities.Role;
import kz.maks.realestate.parser.entities.User;
import kz.maks.realestate.parser.services.UserService;
import kz.maks.realestate.shared.dtos.UserDto;

import java.util.ArrayList;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kz.maks.core.shared.PasswordUtils.getPasswordHash;

@Bean
public class UserAssembler implements IAssembler<UserDto, User> {

    @Inject
    private UserService userService;

    @Override
    public User assemble(UserDto userDto, User user) {
        user.setId(userDto.getId());
        user.setIdentifier(userDto.getIdentifier());

        if (!isNullOrEmpty(userDto.getCredentials())) {
            user.setCredentials(getPasswordHash(userDto.getCredentials()));
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMiddleName(userDto.getMiddleName());
        user.setIsActive(userDto.getIsActive());
        {
            user.setRoles(new ArrayList<Role>());

            for (Long roleId : userDto.getRoleIds()) {
                Role role = userService.getRole(roleId);
                user.getRoles().add(role);
            }
        }
        return user;
    }

}
