package kz.maks.realestate.center;

import kz.maks.core.back.DiffLauncher;

public class DbDiffMain {

    public static void main(String[] args) {
        DiffLauncher.launch("center_test.hibernate.cfg.xml");
    }

}
