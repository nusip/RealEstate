package kz.maks.realestate.parser.assemblers.listDto.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraSaleListDto;

@Bean
public class KvartiraSaleListDtoAssembler extends AbstractKvartiraListDtoAssembler<KvartiraSale, KvartiraSaleListDto> {

    @Override
    public KvartiraSaleListDto assemble(KvartiraSale entity, KvartiraSaleListDto dto) {
        dto = super.assemble(entity, dto);
        dto.setIsZalog(entity.getIsZalog());
        return dto;
    }

}
