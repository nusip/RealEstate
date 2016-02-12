package kz.maks.realestate.back;

import kz.maks.core.back.DiffLauncher;

public class DbDiffMain {

    public static void main(String[] args) {
        DiffLauncher.launch("back_test.hibernate.cfg.xml");
    }

}
