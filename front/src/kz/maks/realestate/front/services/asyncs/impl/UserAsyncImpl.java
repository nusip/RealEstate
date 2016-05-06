package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.front.services.asyncs.UserAsync;
import kz.maks.realestate.shared.dtos.UserDto;
import kz.maks.realestate.shared.dtos.params.UserSearchParams;

import java.util.concurrent.Callable;

import static kz.maks.realestate.front.services.FrontRemotes.userRemote;

public class UserAsyncImpl extends AbstractAsyncImpl implements UserAsync {

    @Override
    public void get(final String identifier, final String credentials, Callback<UserDto> callback) {
        executeAsync(new Callable<UserDto>() {
            @Override
            public UserDto call() throws Exception {
                return userRemote().get(identifier, credentials);
            }
        }, callback);
    }

    @Override
    public void delete(final Long id, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                userRemote().delete(id);
                return null;
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<UserDto> callback) {
        executeAsync(new Callable<UserDto>() {
            @Override
            public UserDto call() throws Exception {
                return userRemote().getDto(id);
            }
        }, callback);
    }

    @Override
    public void list(final UserSearchParams userSearchParams, Callback<ListResponse<UserDto>> callback) {
        executeAsync(new Callable<ListResponse<UserDto>>() {
            @Override
            public ListResponse<UserDto> call() throws Exception {
                return userRemote().list(userSearchParams);
            }
        }, callback);
    }

    @Override
    public void save(final UserDto userDto, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                userRemote().save(userDto);
                return null;
            }
        }, callback);
    }

}
