package kz.maks.realestate.parser.assemblers.parser;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraSale;
import kz.maks.realestate.parser.models.KvartiraPlain;

@Bean
public class KvartiraSaleEntityAssembler extends AbstractKvartiraEntityAssembler<KvartiraSale> {

    @Override
    public KvartiraSale assemble(KvartiraPlain kvartiraPlain, KvartiraSale entity) {
        entity = super.assemble(kvartiraPlain, entity);
        entity.setIsZalog("В залоге".equalsIgnoreCase(kvartiraPlain.getZalog()));
        return entity;
    }

}
