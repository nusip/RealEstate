package kz.maks.realestate.parser.assemblers.entity.kvartira;

import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.parser.assemblers.entity.AbstractKrishaAdAssembler;
import kz.maks.realestate.parser.entities.AbstractKvartiraEntity;
import kz.maks.realestate.parser.entities.refs.*;
import kz.maks.realestate.parser.services.RefService;
import kz.maks.realestate.shared.dtos.kvartira.AbstractKvartiraDto;
import kz.maks.realestate.shared.refs.Ref;

public abstract class AbstractKvartiraAssembler<DTO extends AbstractKvartiraDto, ENTITY extends AbstractKvartiraEntity>
        extends AbstractKrishaAdAssembler<DTO, ENTITY> {

    @Inject
    protected RefService refService;

    @Override
    public ENTITY assemble(DTO dto, ENTITY entity) {
        entity = super.assemble(dto, entity);
        entity.setKolichestvoKomnat(dto.getKolichestvoKomnat());
//        entity.setZhiloyKomplex(dto.getZhiloyKomplex());
        if (dto.getTipStroyeniyaId() != null) {
            KvartiraTipStroyeniya ref = (KvartiraTipStroyeniya) refService.get(Ref.KvartiraTipStroyeniya, dto.getTipStroyeniyaId());
            entity.setTipStroyeniya(ref);
        }
        entity.setGodPostroyki(dto.getGodPostroyki());
        entity.setEtazh(dto.getEtazh());
        entity.setEtazhnost(dto.getEtazhnost());
        entity.setPloshadObshaya(dto.getPloshadObshaya());
        entity.setPloshadZhilaya(dto.getPloshadZhilaya());
        entity.setPloshadKuhnya(dto.getPloshadKuhnya());
//        entity.setIsObwyaga(dto.getIsObwyaga());

        if (dto.getSostoyaniyeId() != null) {
            KvartiraSostoyaniye ref = (KvartiraSostoyaniye) refService.get(Ref.KvartiraSostoyaniye, dto.getSostoyaniyeId());
            entity.setSostoyaniye(ref);
        }

        if (dto.getTelefonId() != null) {
            KvartiraTelefon ref = (KvartiraTelefon) refService.get(Ref.KvartiraTelefon, dto.getTelefonId());
            entity.setTelefon(ref);
        }
//        entity.setInternet(dto.getInternet());

        if (dto.getSanuzelId() != null) {
            KvartiraSanuzel ref = (KvartiraSanuzel) refService.get(Ref.KvartiraSanuzel, dto.getSanuzelId());
            entity.setSanuzel(ref);
        }

        if (dto.getBalkonId() != null) {
            Balkon ref = (Balkon) refService.get(Ref.Balkon, dto.getBalkonId());
            entity.setBalkon(ref);
        }

        if (dto.getDverId() != null) {
            Dver ref = (Dver) refService.get(Ref.Dver, dto.getDverId());
            entity.setDver(ref);
        }
//        entity.setParkovka(dto.getParkovka());
//        entity.setMebel(dto.getMebel());

        if (dto.getPolId() != null) {
            Pol ref = (Pol) refService.get(Ref.Pol, dto.getPolId());
            entity.setPol(ref);
        }

        if (dto.getPlanirovkaId() != null) {
            Planirovka ref = (Planirovka) refService.get(Ref.Planirovka, dto.getPlanirovkaId());
            entity.setPlanirovka(ref);
        }

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
