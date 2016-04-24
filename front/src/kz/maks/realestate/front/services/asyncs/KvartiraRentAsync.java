package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.Callback;
import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

import java.util.List;

public interface KvartiraRentAsync
        extends ICRUDAsync<KvartiraRentSearchParams, KvartiraRentDto, KvartiraRentDto> {

    void listHistory(Long id, Callback<List<KvartiraRentDto>> callback);

}
