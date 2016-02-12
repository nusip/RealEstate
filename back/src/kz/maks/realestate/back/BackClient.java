package kz.maks.realestate.back;

import kz.maks.core.front.BaseClient;
import kz.maks.core.front.ClientConfig;

public class BackClient extends BaseClient {

    public BackClient() {
        super(new ClientConfig("localhost", BackRemotes.class, false, 1098));
    }

    @Override
    public void afterInit() {}

}
