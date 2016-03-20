package kz.maks.realestate.parser.assemblers.entity.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

@Bean
public class DomRentAssembler extends AbstractDomAssembler<DomRentDto, DomRent> {

    @Override
    public DomRent assemble(DomRentDto dto, DomRent entity) {
        entity = super.assemble(dto, entity);
        entity.setKakSdayete(dto.getKakSdayete());
        return entity;
    }

}
