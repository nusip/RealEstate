package kz.maks.realestate.center;

import kz.maks.core.back.BaseServer;
import kz.maks.core.back.ServerConfig;
import kz.maks.realestate.parser.parsers.RegionsParser;
import kz.maks.realestate.parser.services.RegionService;
import org.apache.log4j.Logger;

public class CentralParserServer extends BaseServer {

    private Logger log = Logger.getLogger(CentralParserServer.class);

    public CentralParserServer() {
        super(new ServerConfig());
    }

    @Override
    public void afterInit() {
        RegionService regionService = diServerCore.getProxy(RegionService.class);
        RegionsParser regionsParser = diServerCore.getBean(RegionsParser.class);

        if (!regionService.hasAnyRegion()) {
            regionsParser.parseRegions();
        }

        log.info("PARSER SERVER STARTED");
    }

}
