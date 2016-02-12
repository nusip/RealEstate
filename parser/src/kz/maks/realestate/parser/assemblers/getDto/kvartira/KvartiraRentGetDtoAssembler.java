package kz.maks.realestate.parser.assemblers.getDto.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.shared.dtos.get.kvartira.KvartiraRentGetDto;

@Bean
public class KvartiraRentGetDtoAssembler extends AbstractKvartiraGetDtoAssembler<KvartiraRent, KvartiraRentGetDto> {

    @Override
    public KvartiraRentGetDto assemble(KvartiraRent entity, KvartiraRentGetDto details) {
        details = super.assemble(entity, details);
        details.setKakSdayete(entity.getKakSdayete());
        return details;
    }

}
