package kz.maks.realestate.back;

import kz.maks.core.back.BaseServer;
import kz.maks.core.back.ServerConfig;
import kz.maks.realestate.back.jobs.ActivationChecker;
import kz.maks.realestate.back.jobs.RegionsUpdater;
import kz.maks.realestate.parser.parsers.RegionsParser;
import kz.maks.realestate.parser.services.RegionService;
import org.apache.log4j.Logger;

public class BackServer extends BaseServer {

    private Logger log = Logger.getLogger(BackServer.class);

    public BackServer() {
        super(new ServerConfig());
    }

    @Override
    public void afterInit() {
//        new BackClient().start();

//        diServerCore.getBean(ActivationChecker.class).check();

        RegionService regionService = diServerCore.getProxy(RegionService.class);
//        RegionsUpdater regionsUpdater = diServerCore.getBean(RegionsUpdater.class);
        RegionsParser regionsParser = diServerCore.getBean(RegionsParser.class);

        if (!regionService.hasAnyRegion()) {
//            regionsUpdater.update();
            regionsParser.parseRegions();
        }

        log.info("BACK SERVER STARTED");
    }

}
