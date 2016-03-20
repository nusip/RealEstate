package kz.maks.realestate.front;

import kz.maks.realestate.shared.dtos.UserDto;

public class UserUtils {

    private static UserDto connected;

    public static void setConnected(UserDto userDto) {
        connected = userDto;
    }

    public static UserDto connected() {
        return connected;
    }
}
