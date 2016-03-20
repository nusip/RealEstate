package kz.maks.realestate.parser.assemblers.dto.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

@Bean
public class DomSaleDtoAssembler extends AbstractDomDtoAssembler<DomSale, DomSaleDto> {

    @Override
    public DomSaleDto assemble(DomSale entity, DomSaleDto dto) {
        dto = super.assemble(entity, dto);
        dto.setIsZalog(entity.getIsZalog());
        return dto;
    }

}
