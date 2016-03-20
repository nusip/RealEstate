package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

public interface KvartiraRentAsync
        extends ICRUDAsync<KvartiraRentSearchParams, KvartiraRentDto, KvartiraRentDto> {

}
