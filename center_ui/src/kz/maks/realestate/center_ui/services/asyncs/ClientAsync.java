package kz.maks.realestate.center_ui.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.ClientDto;
import kz.maks.realestate.shared.dtos.params.ClientSearchParams;

public interface ClientAsync extends ICRUDAsync<ClientSearchParams, ClientDto, ClientDto> {

}
