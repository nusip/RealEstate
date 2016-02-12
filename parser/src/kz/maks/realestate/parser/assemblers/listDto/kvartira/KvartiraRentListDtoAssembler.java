package kz.maks.realestate.parser.assemblers.listDto.kvartira;

import kz.maks.core.back.annotations.Bean;
import kz.maks.realestate.parser.entities.KvartiraRent;
import kz.maks.realestate.shared.dtos.list.kvartira.KvartiraRentListDto;

@Bean
public class KvartiraRentListDtoAssembler extends AbstractKvartiraListDtoAssembler<KvartiraRent, KvartiraRentListDto> {

    @Override
    public KvartiraRentListDto assemble(KvartiraRent entity, KvartiraRentListDto dto) {
        dto = super.assemble(entity, dto);
        dto.setKakSdayete(entity.getKakSdayete());
        return dto;
    }

}
