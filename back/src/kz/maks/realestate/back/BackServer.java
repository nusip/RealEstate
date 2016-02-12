package kz.maks.realestate.back;

import kz.maks.core.back.BaseServer;
import kz.maks.core.back.ServerConfig;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.back.jobs.ActivationChecker;
import kz.maks.realestate.back.jobs.RegionsUpdater;
import kz.maks.realestate.parser.services.RegionService;

public class BackServer extends BaseServer {

    private static final String ROOT_PACKAGE = "kz.maks.realestate";
    private static final String HIBERNATE_CFG_FILE_NAME = "back.hibernate.cfg.xml";
    private static final int RMI_REGISTRY_PORT = Utils.DEFAULT_RMI_REGISTRY_PORT;

    public BackServer() {
        super(new ServerConfig(ROOT_PACKAGE, HIBERNATE_CFG_FILE_NAME, RMI_REGISTRY_PORT));
    }

    @Override
    public void afterInit() {
        new BackClient().start();

        diServerCore.getBean(ActivationChecker.class).check();

        RegionService parserService = diServerCore.getProxy(RegionService.class);
        RegionsUpdater regionsUpdater = diServerCore.getBean(RegionsUpdater.class);

        if (!parserService.hasAnyRegion()) {
            regionsUpdater.update();
        }

        System.out.println("BACK SERVER STARTED");
    }

}
