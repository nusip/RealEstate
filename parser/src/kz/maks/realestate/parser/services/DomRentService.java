package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

public interface DomRentService {

    ListResponse<DomRentListDto> list(DomRentSearchParams params);

    DomRentGetDto get(Long id);

    void save(DomRentGetDto dto);

    void delete(Long id);

}
