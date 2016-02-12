package kz.maks.realestate.parser.assemblers.getDto.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.shared.dtos.get.dom.DomSaleGetDto;

@Bean
public class DomSaleGetDtoAssembler extends AbstractDomGetDtoAssembler<DomSale, DomSaleGetDto> {

    @Override
    public DomSaleGetDto assemble(DomSale entity, DomSaleGetDto dto) {
        dto = super.assemble(entity, dto);
        dto.setIsZalog(entity.getIsZalog());
        return dto;
    }

}
