package kz.maks.realestate.parser.assemblers.listDto.kvartira;

import kz.maks.core.back.assemblers.IAssembler;
import kz.maks.realestate.parser.entities.AbstractKvartiraEntity;
import kz.maks.realestate.shared.dtos.list.kvartira.AbstractKvartiraListDto;

public abstract class AbstractKvartiraListDtoAssembler<ENTITY extends AbstractKvartiraEntity, RECORD extends AbstractKvartiraListDto>
        implements IAssembler<ENTITY, RECORD> {

    @Override
    public RECORD assemble(ENTITY entity, RECORD dto) {
        dto.setId(entity.getId());
        dto.setKolichestvoKomnat(entity.getKolichestvoKomnat());
        dto.setCena(entity.getCena());
        dto.setValyuta(entity.getValyuta());
        dto.setRegion(entity.getRegion() != null ? entity.getRegion().getName() : null);
        dto.setZhiloyKomplex(entity.getZhiloyKomplex());
        dto.setUlicaDom(entity.getUlicaDom());
        dto.setTipStroyeniya(entity.getTipStroyeniya());
        dto.setGodPostroyki(entity.getGodPostroyki());
        dto.setEtazh(entity.getEtazh());
        dto.setEtazhnost(entity.getEtazhnost());
        dto.setPloshadObshaya(entity.getPloshadObshaya());
        dto.setPloshadZhilaya(entity.getPloshadZhilaya());
        dto.setPloshadKuhnya(entity.getPloshadKuhnya());
        dto.setIsObwyaga(entity.getIsObwyaga());
        dto.setSostoyaniye(entity.getSostoyaniye());
        dto.setTelefon(entity.getTelefon());
        dto.setInternet(entity.getInternet());
        dto.setSanuzel(entity.getSanuzel());
        dto.setBalkon(entity.getBalkon());
        dto.setDver(entity.getDver());
        dto.setParkovka(entity.getParkovka());
        dto.setMebel(entity.getMebel());
        dto.setPol(entity.getPol());
        dto.setVysotaPotolkov(entity.getVysotaPotolkov());
        dto.setReshetkiNaOknah(entity.getReshetkiNaOknah());
        dto.setOhrana(entity.getOhrana());
        dto.setDomofon(entity.getDomofon());
        dto.setKodovyZamok(entity.getKodovyZamok());
        dto.setSignalizaciya(entity.getSignalizaciya());
        dto.setVideonablyudeniye(entity.getVideonablyudeniye());
        dto.setVideomofon(entity.getVideomofon());
        dto.setKonsyerzh(entity.getKonsyerzh());

        return dto;
    }

}
