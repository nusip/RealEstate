package kz.maks.realestate.parser.assemblers.dto.dom;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.entities.DomRent;
import kz.maks.realestate.shared.dtos.dom.DomRentDto;

import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.core.shared.Utils.extractTitle;

@Bean
public class DomRentDtoAssembler extends AbstractDomDtoAssembler<DomRent, DomRentDto> {

    @Override
    public DomRentDto assemble(DomRent entity, DomRentDto dto) {
        dto = super.assemble(entity, dto);
        dto.setKakSdayeteId(extractId(entity.getKakSdayete()));
        dto.setKakSdayete(extractTitle(entity.getKakSdayete()));
        return dto;
    }

}
