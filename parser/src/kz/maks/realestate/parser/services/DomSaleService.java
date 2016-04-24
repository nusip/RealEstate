package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

import java.util.List;

public interface DomSaleService {

    ListResponse<DomSaleDto> list(DomSaleSearchParams params);

    DomSaleDto get(Long id);

    void save(DomSaleDto dto);

    void delete(Long id);

    List<DomSaleDto> listHistory(Long id);

}
