package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.front.services.FrontRemotes;
import kz.maks.realestate.front.services.asyncs.RefAsync;
import kz.maks.realestate.shared.refs.Ref;

import java.util.List;
import java.util.concurrent.Callable;

public class RefAsyncImpl extends AbstractAsyncImpl implements RefAsync {

    @Override
    public void list(final Ref ref, Callback<List<RefDto>> callback) {
        executeAsync(new Callable<List<RefDto>>() {
            @Override
            public List<RefDto> call() throws Exception {
                return FrontRemotes.refRemote().list(ref);
            }
        }, callback);
    }

    @Override
    public void save(final Ref ref, final List<RefDto> refDtoList, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                FrontRemotes.refRemote().save(ref, refDtoList);
                return null;
            }
        }, callback);
    }

}
