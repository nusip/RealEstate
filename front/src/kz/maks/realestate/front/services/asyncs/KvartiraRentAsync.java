package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraRentListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;

public interface KvartiraRentAsync
        extends ICRUDAsync<KvartiraRentSearchParams, KvartiraRentListDto, KvartiraRentGetDto> {

}
