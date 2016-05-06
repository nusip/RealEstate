package kz.maks.realestate.front;

import com.google.common.collect.Lists;
import kz.maks.realestate.shared.RoleName;
import kz.maks.realestate.shared.dtos.UserDto;

import static com.google.common.collect.Lists.newArrayList;

public class ConnectedUser {

    private static UserDto userDto;

    // TODO remove later
    static {
        userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFullName("Системный пользователь");
        userDto.setRoleNames(newArrayList(RoleName.ROOT));
    }

    public static void set(UserDto userDto) {
        ConnectedUser.userDto = userDto;
    }

    public static UserDto get() {
        return userDto;
    }

    public static boolean is(String roleName) {
        return userDto.getRoleNames().contains(roleName);
    }

    public static boolean isRoot() {
        return is(RoleName.ROOT);
    }

}
