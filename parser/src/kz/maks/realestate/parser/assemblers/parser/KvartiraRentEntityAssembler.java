package kz.maks.realestate.parser.assemblers.parser;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.parser.models.KvartiraPlain;

@Bean
public class KvartiraRentEntityAssembler extends AbstractKvartiraEntityAssembler<KvartiraRent> {

    @Override
    public KvartiraRent assemble(KvartiraPlain kvartiraPlain, KvartiraRent entity) {
        entity = super.assemble(kvartiraPlain, entity);
        // TODO set kakSdayete
        return entity;
    }

}
