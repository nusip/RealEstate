package kz.maks.realestate.parser.assemblers.entity.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraSaleDto;

@Bean
public class KvartiraSaleAssembler extends AbstractKvartiraAssembler<KvartiraSaleDto, KvartiraSale> {

    @Override
    public KvartiraSale assemble(KvartiraSaleDto dto, KvartiraSale entity) {
        entity = super.assemble(dto, entity);
        entity.setIsZalog(dto.getIsZalog());
        return entity;
    }

}
