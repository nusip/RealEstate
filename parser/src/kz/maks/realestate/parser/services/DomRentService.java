package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.dtos.params.DomRentSearchParams;

import java.util.List;

public interface DomRentService {

    ListResponse<DomRentDto> list(DomRentSearchParams params);

    DomRentDto get(Long id);

    void save(DomRentDto dto);

    void delete(Long id);

    List<DomRentDto> listHistory(Long id);

}
