package kz.maks.realestate.parser.assemblers.listDto.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.shared.dtos.list.dom.DomSaleListDto;

@Bean
public class DomSaleListDtoAssembler extends AbstractDomListDtoAssembler<DomSale, DomSaleListDto> {

    @Override
    public DomSaleListDto assemble(DomSale entity, DomSaleListDto dto) {
        dto = super.assemble(entity, dto);
        dto.setIsZalog(entity.getIsZalog());
        return dto;
    }

}
