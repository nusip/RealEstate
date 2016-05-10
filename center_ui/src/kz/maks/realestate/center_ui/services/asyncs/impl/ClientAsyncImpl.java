package kz.maks.realestate.center_ui.services.asyncs.impl;

import kz.maks.core.front.services.Callback;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.center_ui.services.asyncs.ClientAsync;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;

public class ClientAsyncImpl implements ClientAsync {
    @Override
    public void delete(Long id, Callback<Void> callback) {

    }

    @Override
    public void get(Long id, Callback<ClientDto> callback) {

    }

    @Override
    public void list(ClientSearchParams clientSearchParams, Callback<ListResponse<ClientDto>> callback) {

    }

    @Override
    public void save(ClientDto clientDto, Callback<Void> callback) {

    }
}
