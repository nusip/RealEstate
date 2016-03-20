package kz.maks.realestate.parser.assemblers.dto.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

@Bean
public class DomRentDtoAssembler extends AbstractDomDtoAssembler<DomRent, DomRentDto> {

    @Override
    public DomRentDto assemble(DomRent entity, DomRentDto dto) {
        dto = super.assemble(entity, dto);
        dto.setKakSdayete(entity.getKakSdayete());
        return dto;
    }

}
