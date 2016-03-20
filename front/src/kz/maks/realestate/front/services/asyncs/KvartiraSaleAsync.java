package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

public interface KvartiraSaleAsync
        extends ICRUDAsync<KvartiraSaleSearchParams, KvartiraSaleDto, KvartiraSaleDto> {

}
