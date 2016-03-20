package kz.maks.realestate.parser.assemblers.entity.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

@Bean
public class KvartiraRentAssembler extends AbstractKvartiraAssembler<KvartiraRentDto, KvartiraRent> {

    @Override
    public KvartiraRent assemble(KvartiraRentDto dto, KvartiraRent entity) {
        entity = super.assemble(dto, entity);
        entity.setKakSdayete(dto.getKakSdayete());
        return entity;
    }

}
