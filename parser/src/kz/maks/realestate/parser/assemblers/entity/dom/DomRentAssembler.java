package kz.maks.realestate.parser.assemblers.entity.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.parser.entities.refs.KakSdayete;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;
import kz.maks.realestate.shared.refs.Ref;

@Bean
public class DomRentAssembler extends AbstractDomAssembler<DomRentDto, DomRent> {

    @Override
    public DomRent assemble(DomRentDto dto, DomRent entity) {
        entity = super.assemble(dto, entity);

        if (dto.getKakSdayeteId() != null) {
            KakSdayete ref = (KakSdayete) refService.get(Ref.KakSdayete, dto.getKakSdayeteId());
            entity.setKakSdayete(ref);
        }

        return entity;
    }

}
