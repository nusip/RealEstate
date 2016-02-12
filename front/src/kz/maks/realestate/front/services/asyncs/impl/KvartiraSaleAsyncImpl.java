package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.front.services.Callback;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.asyncs.KvartiraSaleAsync;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import java.util.concurrent.Callable;

import static kz.maks.realestate.front.services.FrontRemotes.kvartiraSaleRemote;

public class KvartiraSaleAsyncImpl extends AbstractAsyncImpl implements KvartiraSaleAsync {

    @Override
    public void list(final KvartiraSaleSearchParams params, Callback<ListResponse<KvartiraSaleListDto>> callback) {
        executeAsync(new Callable<ListResponse<KvartiraSaleListDto>>() {
            @Override
            public ListResponse<KvartiraSaleListDto> call() throws Exception {
                return kvartiraSaleRemote().list(params);
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<KvartiraSaleGetDto> callback) {
        executeAsync(new Callable<KvartiraSaleGetDto>() {
            @Override
            public KvartiraSaleGetDto call() throws Exception {
                return kvartiraSaleRemote().get(id);
            }
        }, callback);
    }

    @Override
    public void save(final KvartiraSaleGetDto dto, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                kvartiraSaleRemote().save(dto);
                return null;
            }
        }, callback);
    }

    @Override
    public void delete(final Long id, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                kvartiraSaleRemote().delete(id);
                return null;
            }
        }, callback);
    }
}
