package kz.maks.realestate.front;

import kz.maks.realestate.shared.dtos.UserDto;

public class UserUtils {

    private static UserDto connected;

    // TODO remove later
    static {
        connected = new UserDto();
        connected.setId(1L);
    }

    public static void setConnected(UserDto userDto) {
        connected = userDto;
    }

    public static UserDto connected() {
        return connected;
    }
}
