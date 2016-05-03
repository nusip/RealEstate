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
    public void delete(Long id, Callback<Void> callback) {
        // TODO
    }

    @Override
    public void get(Long id, Callback<UserDto> callback) {
        // TODO
    }

    @Override
    public void list(UserSearchParams userSearchParams, Callback<ListResponse<UserDto>> callback) {
        // TODO
    }

    @Override
    public void save(UserDto userDto, Callback<Void> callback) {
        // TODO
    }

}
