package kz.maks.realestate.back;

import kz.maks.core.front.BaseClient;
import kz.maks.core.front.ClientConfig;

public class BackClient extends BaseClient {

    public BackClient() {
        super(new ClientConfig(BackRemotes.class, false));
    }

    @Override
    public void afterInit() {}

}
