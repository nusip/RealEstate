package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.asyncs.DomRentAsync;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import java.util.List;
import java.util.concurrent.Callable;

import static kz.maks.realestate.front.services.FrontRemotes.domRentRemote;

public class DomRentAsyncImpl extends AbstractAsyncImpl implements DomRentAsync {

    @Override
    public void list(final DomRentSearchParams params, Callback<ListResponse<DomRentDto>> callback) {
        executeAsync(new Callable<ListResponse<DomRentDto>>() {
            @Override
            public ListResponse<DomRentDto> call() throws Exception {
                return domRentRemote().list(params);
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<DomRentDto> callback) {
        executeAsync(new Callable<DomRentDto>() {
            @Override
            public DomRentDto call() throws Exception {
                return domRentRemote().get(id);
            }
        }, callback);
    }

    @Override
    public void save(final DomRentDto dto, Callback<Void> callback) {
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

    @Override
    public void listHistory(final Long id, Callback<List<DomRentDto>> callback) {
        executeAsync(new Callable<List<DomRentDto>>() {
            @Override
            public List<DomRentDto> call() throws Exception {
                return domRentRemote().listHistory(id);
            }
        }, callback);
    }

}
