package kz.maks.realestate.front.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.realestate.front.services.asyncs.UserAsync;
import kz.maks.realestate.shared.dtos.get.UserDto;

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

}
