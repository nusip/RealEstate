package kz.maks.realestate.parser.assemblers.dto.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

@Bean
public class KvartiraRentDtoAssembler extends AbstractKvartiraDtoAssembler<KvartiraRent, KvartiraRentDto> {

    @Override
    public KvartiraRentDto assemble(KvartiraRent entity, KvartiraRentDto details) {
        details = super.assemble(entity, details);
        details.setKakSdayete(entity.getKakSdayete());
        return details;
    }

}
