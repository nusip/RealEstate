package kz.maks.realestate.parser.assemblers.getDto.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraSaleGetDto;

@Bean
public class KvartiraSaleGetDtoAssembler extends AbstractKvartiraGetDtoAssembler<KvartiraSale, KvartiraSaleGetDto> {

    @Override
    public KvartiraSaleGetDto assemble(KvartiraSale entity, KvartiraSaleGetDto details) {
        details = super.assemble(entity, details);
        details.setIsZalog(entity.getIsZalog());
        return details;
    }

}
