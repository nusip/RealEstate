package kz.maks.realestate.back.jobs;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Job;
import kz.maks.core.back.jobs.IJob;
import kz.maks.core.shared.Utils;

//@Job(interval = Utils.ONE_WEEK)
public class RealtorsUpdaterJob implements IJob {

    @Inject
    private RealtorsUpdater realtorsUpdater;

    @Override
    public void execute() throws Exception {
        realtorsUpdater.update();
    }

}
