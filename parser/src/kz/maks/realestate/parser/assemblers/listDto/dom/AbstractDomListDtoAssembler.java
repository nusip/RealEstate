package kz.maks.realestate.parser.assemblers.listDto.dom;

import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.AbstractDomEntity;
import kz.maks.realestate.shared.dtos.list.dom.AbstractDomListDto;

public abstract class AbstractDomListDtoAssembler<ENTITY extends AbstractDomEntity, RECORD extends AbstractDomListDto>
        implements IAssembler<ENTITY, RECORD> {

    @Override
    public RECORD assemble(ENTITY entity, RECORD dto) {
        dto.setId(entity.getId());
        dto.setCena(entity.getCena());
        dto.setValyuta(entity.getValyuta());
        dto.setRegion(entity.getRegion() != null ? entity.getRegion().getName() : null);
        dto.setUlicaDom(entity.getUlicaDom());
        dto.setRaznoe(entity.getRaznoe());
        dto.setTelNumbers(entity.getTelNumbers());
        dto.setPhotoPaths(entity.getPhotoPaths());

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
        dto.setReshetkiNaOknah(entity.getReshetkiNaOknah());
        dto.setDomofon(entity.getDomofon());
        dto.setSignalizaciya(entity.getSignalizaciya());
        dto.setVideomofon(entity.getVideomofon());
        dto.setVideonablyudeniye(entity.getVideonablyudeniye());
        dto.setKruglosutochnayaOhrana(entity.getKruglosutochnayaOhrana());

        return dto;
    }

}
