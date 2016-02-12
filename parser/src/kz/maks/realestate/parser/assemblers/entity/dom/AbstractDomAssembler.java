package kz.maks.realestate.parser.assemblers.entity.dom;

import kz.maks.realestate.parser.assemblers.entity.AbstractKrishaAdAssembler;
import kz.maks.realestate.parser.entities.AbstractDomEntity;
import kz.maks.realestate.shared.dtos.get.dom.AbstractDomGetDto;

public abstract class AbstractDomAssembler<DTO extends AbstractDomGetDto, ENTITY extends AbstractDomEntity>
        extends AbstractKrishaAdAssembler<DTO, ENTITY> {

    @Override
    public ENTITY assemble(DTO dto, ENTITY entity) {
        entity = super.assemble(dto, entity);
        entity.setKolichestvoKomnat(dto.getKolichestvoKomnat());
        entity.setTipStroyeniya(dto.getTipStroyeniya());
        entity.setKolichestvoUrovney(dto.getKolichestvoUrovney());
        entity.setPloshadObshaya(dto.getPloshadObshaya());
        entity.setPloshadZhilaya(dto.getPloshadZhilaya());
        entity.setPloshadKuhnya(dto.getPloshadKuhnya());
        entity.setPloshadUchastka(dto.getPloshadUchastka());
        entity.setKakOgorojen(dto.getKakOgorojen());
        entity.setSostoyaniye(dto.getSostoyaniye());
        entity.setTelefon(dto.getTelefon());
        entity.setInternet(dto.getInternet());
        entity.setSanuzel(dto.getSanuzel());
        entity.setKanalizaciya(dto.getKanalizaciya());
        entity.setVoda(dto.getVoda());
        entity.setElektrichestvo(dto.getElektrichestvo());
        entity.setOtopleniye(dto.getOtopleniye());
        entity.setGaz(dto.getGaz());
        entity.setPokrytieKryshi(dto.getPokrytieKryshi());
        entity.setVysotaPotolkov(dto.getVysotaPotolkov());
        entity.setReshetkiNaOknah(dto.getReshetkiNaOknah());
        entity.setDomofon(dto.getDomofon());
        entity.setSignalizaciya(dto.getSignalizaciya());
        entity.setVideomofon(dto.getVideomofon());
        entity.setVideonablyudeniye(dto.getVideonablyudeniye());
        entity.setKruglosutochnayaOhrana(dto.getKruglosutochnayaOhrana());
        return entity;
    }

}
