package kz.maks.realestate.parser.services;

import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.shared.refs.Ref;

import java.util.List;

public interface RefService {

    List<RefDto> list(Ref ref);

    void save(Ref ref, List<RefDto> dtos);

}
