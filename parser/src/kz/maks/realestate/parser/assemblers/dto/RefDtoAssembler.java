package kz.maks.realestate.parser.assemblers.dto;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.parser.entities.refs.AbstractRefEntity;

@Bean
public class RefDtoAssembler implements IAssembler<AbstractRefEntity, RefDto> {

    @Override
    public RefDto assemble(AbstractRefEntity abstractRefEntity, RefDto refDto) {
        refDto.setId(abstractRefEntity.getId());
        refDto.setCode(abstractRefEntity.getCode());
        refDto.setTitle(abstractRefEntity.getTitle());
        return refDto;
    }

}
