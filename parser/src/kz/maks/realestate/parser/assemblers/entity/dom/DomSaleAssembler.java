package kz.maks.realestate.parser.assemblers.entity.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomSale;
import kz.maks.realestate.shared.dtos.get.dom.DomSaleGetDto;

@Bean
public class DomSaleAssembler extends AbstractDomAssembler<DomSaleGetDto, DomSale> {

    @Override
    public DomSale assemble(DomSaleGetDto dto, DomSale entity) {
        entity = super.assemble(dto, entity);
        entity.setIsZalog(dto.getIsZalog());
        return entity;
    }

}
