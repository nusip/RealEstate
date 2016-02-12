package kz.maks.realestate.center;

import kz.maks.core.back.BaseServer;
import kz.maks.core.back.ServerConfig;
import kz.maks.realestate.parser.parsers.RegionsParser;
import kz.maks.realestate.parser.services.RegionService;

public class CentralParserServer extends BaseServer {

    private static final String ROOT_PACKAGE = "kz.maks.realestate";
    private static final String HIBERNATE_CFG_FILE_NAME = "center.hibernate.cfg.xml";
    private static final int RMI_REGISTRY_PORT = 1098;

    public CentralParserServer() {
        super(new ServerConfig(ROOT_PACKAGE, HIBERNATE_CFG_FILE_NAME, RMI_REGISTRY_PORT));
    }

    @Override
    public void afterInit() {
        RegionService regionService = diServerCore.getProxy(RegionService.class);
        RegionsParser regionsParser = diServerCore.getBean(RegionsParser.class);

        if (!regionService.hasAnyRegion()) {
            regionsParser.parseRegions();
        }

        System.out.println("PARSER SERVER STARTED");
    }

}
