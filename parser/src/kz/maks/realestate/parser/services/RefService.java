package kz.maks.realestate.parser.services;

import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.parser.entities.refs.AbstractRefEntity;
import kz.maks.realestate.shared.refs.Ref;

import java.util.List;

public interface RefService {

    List<RefDto> list(Ref ref);

    void save(Ref ref, List<RefDto> dtos);

    AbstractRefEntity get(Ref ref, Long id);

    AbstractRefEntity get(Ref ref, String code);

}
