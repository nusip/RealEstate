package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraRentListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;
import kz.maks.realestate.parser.models.KvartiraPlain;

public interface KvartiraRentService {

    void save(KvartiraPlain kvartiraPlain);

    ListResponse<KvartiraRentListDto> list(KvartiraRentSearchParams params);

    KvartiraRentGetDto get(Long id);

    void save(KvartiraRentGetDto dto);

    void delete(Long id);

    boolean exists(String krishaId);

}
