package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.asyncs.KvartiraRentAsync;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

import java.util.concurrent.Callable;

import static kz.maks.realestate.front.services.FrontRemotes.kvartiraRentRemote;

public class KvartiraRentAsyncImpl extends AbstractAsyncImpl implements KvartiraRentAsync {

    @Override
    public void list(final KvartiraRentSearchParams params, Callback<ListResponse<KvartiraRentDto>> callback) {
        executeAsync(new Callable<ListResponse<KvartiraRentDto>>() {
            @Override
            public ListResponse<KvartiraRentDto> call() throws Exception {
                return kvartiraRentRemote().list(params);
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<KvartiraRentDto> callback) {
        executeAsync(new Callable<KvartiraRentDto>() {
            @Override
            public KvartiraRentDto call() throws Exception {
                return kvartiraRentRemote().get(id);
            }
        }, callback);
    }

    @Override
    public void save(final KvartiraRentDto dto, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                kvartiraRentRemote().save(dto);
                return null;
            }
        }, callback);
    }

    @Override
    public void delete(final Long id, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                kvartiraRentRemote().delete(id);
                return null;
            }
        }, callback);
    }
}
