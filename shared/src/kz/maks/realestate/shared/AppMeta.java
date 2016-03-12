package kz.maks.realestate.shared;

import kz.maks.realestate.shared.dtos.get.UserDto;

import java.io.InputStream;
import java.util.Scanner;

public class AppMeta {

    public static final String PROJECT_NAME = "RealEstate";

    public static String getVersion() {
        InputStream inputStream = AppMeta.class.getResourceAsStream("app.version");
        Scanner scanner = new Scanner(inputStream);
        String revCountStr = scanner.nextLine().trim();
        return revCountStr;
    }

    private static UserDto connectedUser;

    public static UserDto connectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(UserDto user) {
        connectedUser = user;
    }

    // for testing only
    public static void main(String[] args) {
        System.out.println(getVersion());
    }

}
