package kz.maks.realestate.parser.assemblers.entity.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.parser.entities.refs.KakSdayete;
import kz.maks.realestate.shared.dtos.kvartira.KvartiraRentDto;
import kz.maks.realestate.shared.refs.Ref;

@Bean
public class KvartiraRentAssembler extends AbstractKvartiraAssembler<KvartiraRentDto, KvartiraRent> {

    @Override
    public KvartiraRent assemble(KvartiraRentDto dto, KvartiraRent entity) {
        entity = super.assemble(dto, entity);

        if (dto.getKakSdayeteId() != null) {
            KakSdayete ref = (KakSdayete) refService.get(Ref.KakSdayete, dto.getKakSdayeteId());
            entity.setKakSdayete(ref);
        }

        return entity;
    }

}
