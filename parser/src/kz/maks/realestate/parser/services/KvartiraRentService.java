package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.dtos.params.KvartiraRentSearchParams;
import kz.maks.realestate.parser.models.KvartiraPlain;

import java.util.List;

public interface KvartiraRentService {

    void save(KvartiraPlain kvartiraPlain);

    ListResponse<KvartiraRentDto> list(KvartiraRentSearchParams params);

    KvartiraRentDto get(Long id);

    void save(KvartiraRentDto dto);

    void delete(Long id);

    boolean exists(String krishaId);

    List<KvartiraRentDto> listHistory(Long id);

}
