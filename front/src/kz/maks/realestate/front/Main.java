package kz.maks.realestate.front;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        FrontClient client = new FrontClient();
        client.start();
    }

}
