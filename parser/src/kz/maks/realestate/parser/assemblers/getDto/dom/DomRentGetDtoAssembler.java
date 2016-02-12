package kz.maks.realestate.parser.assemblers.getDto.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.shared.dtos.get.dom.DomRentGetDto;

@Bean
public class DomRentGetDtoAssembler extends AbstractDomGetDtoAssembler<DomRent, DomRentGetDto> {

    @Override
    public DomRentGetDto assemble(DomRent entity, DomRentGetDto dto) {
        dto = super.assemble(entity, dto);
        dto.setKakSdayete(entity.getKakSdayete());
        return dto;
    }

}
