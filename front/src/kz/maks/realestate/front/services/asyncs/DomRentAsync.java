package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import java.util.List;

public interface DomRentAsync
        extends ICRUDAsync<DomRentSearchParams, DomRentDto, DomRentDto> {

    void listHistory(Long id, Callback<List<DomRentDto>> callback);

}
