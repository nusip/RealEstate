package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.get.dom.DomSaleGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomSaleListDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

public interface DomSaleService {

    ListResponse<DomSaleListDto> list(DomSaleSearchParams params);

    DomSaleGetDto get(Long id);

    void save(DomSaleGetDto dto);

    void delete(Long id);

}
