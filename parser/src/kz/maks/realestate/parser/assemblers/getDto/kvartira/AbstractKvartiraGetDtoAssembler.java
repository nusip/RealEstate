package kz.maks.realestate.parser.assemblers.getDto.kvartira;

import kz.maks.realestate.parser.assemblers.getDto.AbstractKrishaAdGetDtoAssembler;
import kz.maks.realestate.parser.entities.AbstractKvartiraEntity;
import kz.maks.realestate.shared.dtos.get.kvartira.AbstractKvartiraGetDto;

public abstract class AbstractKvartiraGetDtoAssembler<ENTITY extends AbstractKvartiraEntity, DETAILS extends AbstractKvartiraGetDto>
        extends AbstractKrishaAdGetDtoAssembler<ENTITY, DETAILS> {

    @Override
    public DETAILS assemble(ENTITY entity, DETAILS details) {
        details = super.assemble(entity, details);
        details.setKolichestvoKomnat(entity.getKolichestvoKomnat());
        details.setZhiloyKomplex(entity.getZhiloyKomplex());
        details.setTipStroyeniya(entity.getTipStroyeniya());
        details.setGodPostroyki(entity.getGodPostroyki());
        details.setEtazh(entity.getEtazh());
        details.setEtazhnost(entity.getEtazhnost());
        details.setPloshadObshaya(entity.getPloshadObshaya());
        details.setPloshadZhilaya(entity.getPloshadZhilaya());
        details.setPloshadKuhnya(entity.getPloshadKuhnya());
        details.setIsObwyaga(entity.getIsObwyaga());
        details.setSostoyaniye(entity.getSostoyaniye());
        details.setTelefon(entity.getTelefon());
        details.setInternet(entity.getInternet());
        details.setSanuzel(entity.getSanuzel());
        details.setBalkon(entity.getBalkon());
        details.setDver(entity.getDver());
        details.setParkovka(entity.getParkovka());
        details.setMebel(entity.getMebel());
        details.setPol(entity.getPol());
        details.setVysotaPotolkov(entity.getVysotaPotolkov());
        details.setReshetkiNaOknah(entity.getReshetkiNaOknah());
        details.setOhrana(entity.getOhrana());
        details.setDomofon(entity.getDomofon());
        details.setKodovyZamok(entity.getKodovyZamok());
        details.setSignalizaciya(entity.getSignalizaciya());
        details.setVideonablyudeniye(entity.getVideonablyudeniye());
        details.setVideomofon(entity.getVideomofon());
        details.setKonsyerzh(entity.getKonsyerzh());
        return details;
    }

}
