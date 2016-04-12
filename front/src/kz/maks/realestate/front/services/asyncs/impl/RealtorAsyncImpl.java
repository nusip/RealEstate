package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.FrontRemotes;
import kz.maks.realestate.front.services.asyncs.RealtorAsync;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

import java.util.concurrent.Callable;

public class RealtorAsyncImpl extends AbstractAsyncImpl implements RealtorAsync {

    @Override
    public void list(final RealtorSearchParams params, Callback<ListResponse<RealtorDto>> callback) {
        executeAsync(new Callable<ListResponse<RealtorDto>>() {
            @Override
            public ListResponse<RealtorDto> call() throws Exception {
                return FrontRemotes.realtorRemote().list(params);
            }
        }, callback);
    }

}
