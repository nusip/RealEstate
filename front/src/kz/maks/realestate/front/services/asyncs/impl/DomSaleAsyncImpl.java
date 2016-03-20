package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.asyncs.DomSaleAsync;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

import java.util.concurrent.Callable;

import static kz.maks.realestate.front.services.FrontRemotes.domSaleRemote;

public class DomSaleAsyncImpl extends AbstractAsyncImpl implements DomSaleAsync {

    @Override
    public void list(final DomSaleSearchParams params, Callback<ListResponse<DomSaleDto>> callback) {
        executeAsync(new Callable<ListResponse<DomSaleDto>>() {
            @Override
            public ListResponse<DomSaleDto> call() throws Exception {
                return domSaleRemote().list(params);
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<DomSaleDto> callback) {
        executeAsync(new Callable<DomSaleDto>() {
            @Override
            public DomSaleDto call() throws Exception {
                return domSaleRemote().get(id);
            }
        }, callback);
    }

    @Override
    public void save(final DomSaleDto dto, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                domSaleRemote().save(dto);
                return null;
            }
        }, callback);
    }

    @Override
    public void delete(final Long id, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                domSaleRemote().delete(id);
                return null;
            }
        }, callback);
    }
}
