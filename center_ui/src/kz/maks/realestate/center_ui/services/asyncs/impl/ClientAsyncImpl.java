package kz.maks.realestate.center_ui.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.impl.AbstractAsyncImpl;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.center_ui.services.CenterUIRemotes;
import kz.maks.realestate.center_ui.services.asyncs.ClientAsync;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;

import java.util.concurrent.Callable;

import static kz.maks.realestate.center_ui.services.CenterUIRemotes.clientDeviceRemote;

public class ClientAsyncImpl extends AbstractAsyncImpl implements ClientAsync {

    @Override
    public void delete(final Long id, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                clientDeviceRemote().deleteClient(id);
                return null;
            }
        }, callback);
    }

    @Override
    public void get(final Long id, Callback<ClientDto> callback) {
        executeAsync(new Callable<ClientDto>() {
            @Override
            public ClientDto call() throws Exception {
                return clientDeviceRemote().getClient(id);
            }
        }, callback);
    }

    @Override
    public void list(final ClientSearchParams clientSearchParams, Callback<ListResponse<ClientDto>> callback) {
        executeAsync(new Callable<ListResponse<ClientDto>>() {
            @Override
            public ListResponse<ClientDto> call() throws Exception {
                return clientDeviceRemote().listClients(clientSearchParams);
            }
        }, callback);
    }

    @Override
    public void save(final ClientDto clientDto, Callback<Void> callback) {
        executeAsync(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                clientDeviceRemote().saveClient(clientDto);
                return null;
            }
        }, callback);
    }
}
