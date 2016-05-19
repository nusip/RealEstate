package kz.maks.realestate.parser.jobs;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Job;
import kz.maks.core.back.jobs.IJob;
import kz.maks.realestate.parser.parsers.AdsParser;

import static kz.maks.core.shared.Utils.ONE_HOUR;


//@Job(interval = ONE_HOUR)
public class AdsParserJob implements IJob {

    @Inject
    private AdsParser adsParser;

    @Override
    public void execute() throws Exception {
        adsParser.parseAds();
    }

}
