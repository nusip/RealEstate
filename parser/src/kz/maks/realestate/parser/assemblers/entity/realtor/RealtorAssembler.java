package kz.maks.realestate.parser.assemblers.entity.realtor;

import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.Realtor;
import kz.maks.realestate.shared.dtos.RealtorDto;

@Bean
public class RealtorAssembler implements IAssembler<RealtorDto, Realtor> {

    @Override
    public Realtor assemble(RealtorDto dto, Realtor realtor) {
        realtor.setId(dto.getId());
        realtor.setKrishaId(dto.getKrishaId());
        realtor.setName(dto.getName());
        realtor.setVidDeyatelnosti(dto.getVidDeyatelnosti());
        realtor.setCompany(dto.getCompany());
        realtor.setTelNumbers(dto.getTelNumbers());
        return realtor;
    }

}
