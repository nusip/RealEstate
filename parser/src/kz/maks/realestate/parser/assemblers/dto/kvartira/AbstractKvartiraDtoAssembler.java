package kz.maks.realestate.parser.assemblers.dto.kvartira;

import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.assemblers.dto.AbstractKrishaAdDtoAssembler;
import kz.maks.realestate.parser.entities.AbstractKvartiraEntity;
import kz.maks.realestate.shared.dtos.kvartira.AbstractKvartiraDto;

import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.core.shared.Utils.extractTitle;

public abstract class AbstractKvartiraDtoAssembler<ENTITY extends AbstractKvartiraEntity, DETAILS extends AbstractKvartiraDto>
        extends AbstractKrishaAdDtoAssembler<ENTITY, DETAILS> {

    @Override
    public DETAILS assemble(ENTITY entity, DETAILS details) {
        details = super.assemble(entity, details);
        details.setKolichestvoKomnat(entity.getKolichestvoKomnat());
//        details.setZhiloyKomplex(entity.getZhiloyKomplex());
        details.setTipStroyeniyaId(extractId(entity.getTipStroyeniya()));
        details.setTipStroyeniya(extractTitle(entity.getTipStroyeniya()));
        details.setGodPostroyki(entity.getGodPostroyki());
        details.setEtazh(entity.getEtazh());
        details.setEtazhnost(entity.getEtazhnost());
        details.setPloshadObshaya(entity.getPloshadObshaya());
        details.setPloshadZhilaya(entity.getPloshadZhilaya());
        details.setPloshadKuhnya(entity.getPloshadKuhnya());
//        details.setIsObwyaga(entity.getIsObwyaga());
        details.setSostoyaniyeId(extractId(entity.getSostoyaniye()));
        details.setSostoyaniye(extractTitle(entity.getSostoyaniye()));
        details.setTelefonId(extractId(entity.getTelefon()));
        details.setTelefon(extractTitle(entity.getTelefon()));
//        details.setInternet(entity.getInternet());
        details.setSanuzelId(extractId(entity.getSanuzel()));
        details.setSanuzel(extractTitle(entity.getSanuzel()));
        details.setBalkonId(extractId(entity.getBalkon()));
        details.setBalkon(extractTitle(entity.getBalkon()));
        details.setDverId(extractId(entity.getDver()));
        details.setDver(extractTitle(entity.getDver()));
//        details.setParkovka(entity.getParkovka());
//        details.setMebel(entity.getMebel());
        details.setPolId(extractId(entity.getPol()));
        details.setPol(extractTitle(entity.getPol()));
        details.setPlanirovkaId(extractId(entity.getPlanirovka()));
        details.setPlanirovka(extractTitle(entity.getPlanirovka()));
//        details.setVysotaPotolkov(entity.getVysotaPotolkov());
//        details.setReshetkiNaOknah(entity.getReshetkiNaOknah());
//        details.setOhrana(entity.getOhrana());
//        details.setDomofon(entity.getDomofon());
//        details.setKodovyZamok(entity.getKodovyZamok());
//        details.setSignalizaciya(entity.getSignalizaciya());
//        details.setVideonablyudeniye(entity.getVideonablyudeniye());
//        details.setVideomofon(entity.getVideomofon());
//        details.setKonsyerzh(entity.getKonsyerzh());
        details.setKvartira(entity.getKvartira());
        return details;
    }

}
