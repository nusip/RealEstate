package kz.maks.realestate.parser.assemblers.dto.realtor;

import com.google.common.collect.Lists;
import kz.maks.core.back.annotations.Bean;
import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.Realtor;
import kz.maks.realestate.shared.dtos.RealtorDto;

@Bean
public class RealtorDtoAssembler implements IAssembler<Realtor, RealtorDto> {

    @Override
    public RealtorDto assemble(Realtor realtor, RealtorDto realtorDto) {
        realtorDto.setId(realtor.getId());
        realtorDto.setKrishaId(realtor.getKrishaId());
        realtorDto.setName(realtor.getName());
        realtorDto.setVidDeyatelnosti(realtor.getVidDeyatelnosti());
        realtorDto.setCompany(realtor.getCompany());
        realtorDto.setTelNumbers(Lists.newArrayList(realtor.getTelNumbers()));
        return realtorDto;
    }

}
