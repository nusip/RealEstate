package kz.maks.realestate.parser.assemblers.dto.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

@Bean
public class KvartiraSaleDtoAssembler extends AbstractKvartiraDtoAssembler<KvartiraSale, KvartiraSaleDto> {

    @Override
    public KvartiraSaleDto assemble(KvartiraSale entity, KvartiraSaleDto details) {
        details = super.assemble(entity, details);
        details.setIsZalog(entity.getIsZalog());
        return details;
    }

}
