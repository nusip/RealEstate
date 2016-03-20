package kz.maks.realestate.parser.assemblers.entity.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;

@Bean
public class DomSaleAssembler extends AbstractDomAssembler<DomSaleDto, DomSale> {

    @Override
    public DomSale assemble(DomSaleDto dto, DomSale entity) {
        entity = super.assemble(dto, entity);
        entity.setIsZalog(dto.getIsZalog());
        return entity;
    }

}
