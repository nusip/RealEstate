package kz.maks.realestate.center_ui;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException,
            ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        CenterUIClient client = new CenterUIClient();
        client.start();
    }

}
