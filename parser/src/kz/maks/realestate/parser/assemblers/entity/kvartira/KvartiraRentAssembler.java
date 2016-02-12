package kz.maks.realestate.parser.assemblers.entity.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;

@Bean
public class KvartiraRentAssembler extends AbstractKvartiraAssembler<KvartiraRentGetDto, KvartiraRent> {

    @Override
    public KvartiraRent assemble(KvartiraRentGetDto dto, KvartiraRent entity) {
        entity = super.assemble(dto, entity);
        entity.setKakSdayete(dto.getKakSdayete());
        return entity;
    }

}
