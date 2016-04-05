package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.models.KvartiraPlain;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import java.util.List;

public interface KvartiraSaleService {

    ListResponse<KvartiraSaleDto> list(KvartiraSaleSearchParams params);

    KvartiraSaleDto get(Long id);

    void save(KvartiraSaleDto dto);

    void delete(Long id);

    void saveKvartiraSale(KvartiraPlain kvartiraPlain);

    boolean kvartiraSaleExists(String krishaId);

    Long getMaxUpdatedAt();

    List<KvartiraSaleDto> listNew(Long lastUpdatedAt);

    List<KvartiraSaleDto> listHistory(Long id);

}
