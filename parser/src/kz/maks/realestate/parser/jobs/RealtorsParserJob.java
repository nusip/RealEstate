package kz.maks.realestate.parser.jobs;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Job;
import kz.maks.core.back.jobs.IJob;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.parsers.RealtorListParser;

//@Job(interval = Utils.ONE_WEEK)
public class RealtorsParserJob implements IJob {

    @Inject
    private RealtorListParser realtorListParser;

    @Override
    public void execute() throws Exception {
        realtorListParser.parseRealtors();
    }

}
