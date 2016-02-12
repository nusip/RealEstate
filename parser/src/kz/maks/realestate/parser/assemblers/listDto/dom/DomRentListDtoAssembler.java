package kz.maks.realestate.parser.assemblers.listDto.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.shared.dtos.list.dom.DomRentListDto;

@Bean
public class DomRentListDtoAssembler extends AbstractDomListDtoAssembler<DomRent, DomRentListDto> {

    @Override
    public DomRentListDto assemble(DomRent entity, DomRentListDto dto) {
        dto = super.assemble(entity, dto);
        dto.setKakSdayete(entity.getKakSdayete());
        return dto;
    }

}
