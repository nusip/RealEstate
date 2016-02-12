package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

public interface KvartiraSaleAsync
        extends ICRUDAsync<KvartiraSaleSearchParams, KvartiraSaleListDto, KvartiraSaleGetDto> {

}
