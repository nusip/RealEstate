package kz.maks.realestate.parser.assemblers.entity.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;

@Bean
public class DomRentAssembler extends AbstractDomAssembler<DomRentGetDto, DomRent> {

    @Override
    public DomRent assemble(DomRentGetDto dto, DomRent entity) {
        entity = super.assemble(dto, entity);
        entity.setKakSdayete(dto.getKakSdayete());
        return entity;
    }

}
