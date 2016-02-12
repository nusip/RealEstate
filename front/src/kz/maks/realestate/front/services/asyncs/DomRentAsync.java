package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

public interface DomRentAsync
        extends ICRUDAsync<DomRentSearchParams, DomRentListDto, DomRentGetDto> {

}
