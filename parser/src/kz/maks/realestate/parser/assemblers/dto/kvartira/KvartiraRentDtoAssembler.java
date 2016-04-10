package kz.maks.realestate.parser.assemblers.dto.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;

import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.core.shared.Utils.extractTitle;

@Bean
public class KvartiraRentDtoAssembler extends AbstractKvartiraDtoAssembler<KvartiraRent, KvartiraRentDto> {

    @Override
    public KvartiraRentDto assemble(KvartiraRent entity, KvartiraRentDto details) {
        details = super.assemble(entity, details);
        details.setKakSdayeteId(extractId(entity.getKakSdayete()));
        details.setKakSdayete(extractTitle(entity.getKakSdayete()));
        return details;
    }

}
