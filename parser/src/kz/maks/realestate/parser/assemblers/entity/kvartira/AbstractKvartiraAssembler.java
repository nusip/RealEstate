package kz.maks.realestate.parser.assemblers.entity.kvartira;

import kz.maks.realestate.parser.assemblers.entity.AbstractKrishaAdAssembler;
import kz.maks.realestate.parser.entities.AbstractKvartiraEntity;
import kz.maks.realestate.shared.dtos.kvartira.AbstractKvartiraDto;

public abstract class AbstractKvartiraAssembler<DTO extends AbstractKvartiraDto, ENTITY extends AbstractKvartiraEntity>
        extends AbstractKrishaAdAssembler<DTO, ENTITY> {

    @Override
    public ENTITY assemble(DTO dto, ENTITY entity) {
        entity = super.assemble(dto, entity);
        entity.setKolichestvoKomnat(dto.getKolichestvoKomnat());
//        entity.setZhiloyKomplex(dto.getZhiloyKomplex());
        entity.setTipStroyeniya(dto.getTipStroyeniya());
        entity.setGodPostroyki(dto.getGodPostroyki());
        entity.setEtazh(dto.getEtazh());
        entity.setEtazhnost(dto.getEtazhnost());
        entity.setPloshadObshaya(dto.getPloshadObshaya());
        entity.setPloshadZhilaya(dto.getPloshadZhilaya());
        entity.setPloshadKuhnya(dto.getPloshadKuhnya());
//        entity.setIsObwyaga(dto.getIsObwyaga());
        entity.setSostoyaniye(dto.getSostoyaniye());
        entity.setTelefon(dto.getTelefon());
//        entity.setInternet(dto.getInternet());
        entity.setSanuzel(dto.getSanuzel());
        entity.setBalkon(dto.getBalkon());
        entity.setDver(dto.getDver());
//        entity.setParkovka(dto.getParkovka());
//        entity.setMebel(dto.getMebel());
        entity.setPol(dto.getPol());
        entity.setPlanirovka(dto.getPlanirovka());
//        entity.setVysotaPotolkov(dto.getVysotaPotolkov());
//        entity.setReshetkiNaOknah(dto.getReshetkiNaOknah());
//        entity.setOhrana(dto.getOhrana());
//        entity.setDomofon(dto.getDomofon());
//        entity.setKodovyZamok(dto.getKodovyZamok());
//        entity.setSignalizaciya(dto.getSignalizaciya());
//        entity.setVideonablyudeniye(dto.getVideonablyudeniye());
//        entity.setVideomofon(dto.getVideomofon());
//        entity.setKonsyerzh(dto.getKonsyerzh());
        entity.setKvartira(dto.getKvartira());
        return entity;
    }

}
