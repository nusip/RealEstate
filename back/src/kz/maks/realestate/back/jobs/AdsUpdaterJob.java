package kz.maks.realestate.back.jobs;

import kz.maks.core.back.annotations.Inject;
import kz.maks.core.back.annotations.Job;
import kz.maks.core.back.jobs.IJob;

import static kz.maks.core.shared.Utils.ONE_HOUR;

//@Job(interval = ONE_HOUR)
public class AdsUpdaterJob implements IJob {

    @Inject
    private AdsUpdater adsUpdater;

    @Override
    public void execute() throws Exception {
        adsUpdater.update();
    }

}
