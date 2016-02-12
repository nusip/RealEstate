package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.parser.models.KvartiraPlain;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;
import kz.maks.realestate.shared.dtos.params.KvartiraSaleSearchParams;

import java.rmi.RemoteException;
import java.util.List;

public interface KvartiraSaleService {

    ListResponse<KvartiraSaleListDto> list(KvartiraSaleSearchParams params);

    KvartiraSaleGetDto get(Long id);

    void save(KvartiraSaleGetDto dto);

    void delete(Long id);

    void saveKvartiraSale(KvartiraPlain kvartiraPlain);

    boolean kvartiraSaleExists(String krishaId);

    Long getMaxUpdatedAt();

    List<KvartiraSaleGetDto> listNew(Long lastUpdatedAt);

}
