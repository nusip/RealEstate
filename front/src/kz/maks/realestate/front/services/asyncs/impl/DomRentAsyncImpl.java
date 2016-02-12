package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.asyncs.DomRentAsync;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import java.util.concurrent.Callable;

import static kz.maks.realestate.front.services.FrontRemotes.domRentRemote;

public class DomRentAsyncImpl extends AbstractAsyncImpl implements DomRentAsync {

    @Override
    public void list(final DomRentSearchParams params, Callback<ListResponse<DomRentListDto>> callback) {
        executeAsync(new Callable<ListResponse<DomRentListDto>>() {
            @Override
            public ListResponse<DomRentListDto> call() throws Exception {
                return domRentRemote().list(params);
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<DomRentGetDto> callback) {
        executeAsync(new Callable<DomRentGetDto>() {
            @Override
            public DomRentGetDto call() throws Exception {
                return domRentRemote().get(id);
            }
        }, callback);
    }

    @Override
    public void save(final DomRentGetDto dto, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                domRentRemote().save(dto);
                return null;
            }
        }, callback);
    }

    @Override
    public void delete(final Long id, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                domRentRemote().delete(id);
                return null;
            }
        }, callback);
    }
}
