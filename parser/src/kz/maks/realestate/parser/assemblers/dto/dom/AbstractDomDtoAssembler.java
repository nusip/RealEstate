package kz.maks.realestate.parser.assemblers.dto.dom;

import kz.maks.realestate.parser.assemblers.dto.AbstractKrishaAdDtoAssembler;
import kz.maks.realestate.parser.entities.AbstractDomEntity;
import kz.maks.realestate.shared.dtos.dom.AbstractDomDto;

public abstract class AbstractDomDtoAssembler<ENTITY extends AbstractDomEntity, DTO extends AbstractDomDto>
        extends AbstractKrishaAdDtoAssembler<ENTITY, DTO> {

    @Override
    public DTO assemble(ENTITY entity, DTO dto) {
        dto = super.assemble(entity, dto);
        dto.setKolichestvoKomnat(entity.getKolichestvoKomnat());
        dto.setTipStroyeniya(entity.getTipStroyeniya());
        dto.setKolichestvoUrovney(entity.getKolichestvoUrovney());
        dto.setPloshadObshaya(entity.getPloshadObshaya());
        dto.setPloshadZhilaya(entity.getPloshadZhilaya());
        dto.setPloshadKuhnya(entity.getPloshadKuhnya());
        dto.setPloshadUchastka(entity.getPloshadUchastka());
        dto.setKakOgorojen(entity.getKakOgorojen());
        dto.setSostoyaniye(entity.getSostoyaniye());
        dto.setTelefon(entity.getTelefon());
        dto.setInternet(entity.getInternet());
        dto.setSanuzel(entity.getSanuzel());
        dto.setKanalizaciya(entity.getKanalizaciya());
        dto.setVoda(entity.getVoda());
        dto.setElektrichestvo(entity.getElektrichestvo());
        dto.setOtopleniye(entity.getOtopleniye());
        dto.setGaz(entity.getGaz());
        dto.setPokrytieKryshi(entity.getPokrytieKryshi());
        dto.setVysotaPotolkov(entity.getVysotaPotolkov());
//        dto.setReshetkiNaOknah(entity.getReshetkiNaOknah());
//        dto.setDomofon(entity.getDomofon());
//        dto.setSignalizaciya(entity.getSignalizaciya());
//        dto.setVideomofon(entity.getVideomofon());
//        dto.setVideonablyudeniye(entity.getVideonablyudeniye());
//        dto.setKruglosutochnayaOhrana(entity.getKruglosutochnayaOhrana());
        return dto;
    }

}
