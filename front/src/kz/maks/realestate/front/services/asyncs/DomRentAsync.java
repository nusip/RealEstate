package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

public interface DomRentAsync
        extends ICRUDAsync<DomRentSearchParams, DomRentDto, DomRentDto> {

}
