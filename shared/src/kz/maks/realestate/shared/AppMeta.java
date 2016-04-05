package kz.maks.realestate.shared;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class AppMeta {

    public static final String PROJECT_NAME = "RealEstate";

    public static String getVersion() {
        InputStream inputStream = AppMeta.class.getResourceAsStream("app.version");
        Scanner scanner = new Scanner(inputStream);
        String revCountStr = scanner.nextLine().trim();
        return revCountStr;
    }

    // for testing only
    public static void main(String[] args) {
        System.out.println(getVersion());
    }

}
