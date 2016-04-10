package kz.maks.realestate.parser.assemblers.entity.dom;

import kz.maks.core.back.annotations.Inject;
import kz.maks.realestate.parser.assemblers.entity.AbstractKrishaAdAssembler;
import kz.maks.realestate.parser.entities.AbstractDomEntity;
import kz.maks.realestate.parser.entities.refs.*;
import kz.maks.realestate.parser.services.RefService;
import kz.maks.realestate.shared.dtos.dom.AbstractDomDto;
import kz.maks.realestate.shared.refs.Ref;

public abstract class AbstractDomAssembler<DTO extends AbstractDomDto, ENTITY extends AbstractDomEntity>
        extends AbstractKrishaAdAssembler<DTO, ENTITY> {

    @Inject
    protected RefService refService;

    @Override
    public ENTITY assemble(DTO dto, ENTITY entity) {
        entity = super.assemble(dto, entity);
        entity.setKolichestvoKomnat(dto.getKolichestvoKomnat());

        if (dto.getTipStroyeniyaId() != null) {
            DomTipStroyeniya ref = (DomTipStroyeniya) refService.get(Ref.DomTipStroyeniya, dto.getTipStroyeniyaId());
            entity.setTipStroyeniya(ref);
        }
        entity.setKolichestvoUrovney(dto.getKolichestvoUrovney());
        entity.setPloshadObshaya(dto.getPloshadObshaya());
        entity.setPloshadZhilaya(dto.getPloshadZhilaya());
        entity.setPloshadKuhnya(dto.getPloshadKuhnya());
        entity.setPloshadUchastka(dto.getPloshadUchastka());
        entity.setKakOgorojen(dto.getKakOgorojen());

        if (dto.getSostoyaniyeId() != null) {
            DomSostoyaniye ref = (DomSostoyaniye) refService.get(Ref.DomSostoyaniye, dto.getSostoyaniyeId());
            entity.setSostoyaniye(ref);
        }

        if (dto.getTelefonId() != null) {
            DomTelefon ref = (DomTelefon) refService.get(Ref.DomTelefon, dto.getTelefonId());
            entity.setTelefon(ref);
        }

        if (dto.getInternetId() != null) {
            Internet ref = (Internet) refService.get(Ref.Internet, dto.getInternetId());
            entity.setInternet(ref);
        }

        if (dto.getSanuzelId() != null) {
            DomSanuzel ref = (DomSanuzel) refService.get(Ref.DomSanuzel, dto.getSanuzelId());
            entity.setSanuzel(ref);
        }

        if (dto.getKanalizaciyaId() != null) {
            Kanalizaciya ref = (Kanalizaciya) refService.get(Ref.Kanalizaciya, dto.getKanalizaciyaId());
            entity.setKanalizaciya(ref);
        }

        if (dto.getVodaId() != null) {
            Voda ref = (Voda) refService.get(Ref.Voda, dto.getVodaId());
            entity.setVoda(ref);
        }

        if (dto.getElektrichestvoId() != null) {
            Elektrichestvo ref = (Elektrichestvo) refService.get(Ref.Elektrichestvo, dto.getElektrichestvoId());
            entity.setElektrichestvo(ref);
        }

        if (dto.getOtopleniyeId() != null) {
            Otopleniye ref = (Otopleniye) refService.get(Ref.Otopleniye, dto.getOtopleniyeId());
            entity.setOtopleniye(ref);
        }

        if (dto.getGazId() != null) {
            Gaz ref = (Gaz) refService.get(Ref.Gaz, dto.getGazId());
            entity.setGaz(ref);
        }

        entity.setPokrytieKryshi(dto.getPokrytieKryshi());
        entity.setVysotaPotolkov(dto.getVysotaPotolkov());
//        entity.setReshetkiNaOknah(dto.getReshetkiNaOknah());
//        entity.setDomofon(dto.getDomofon());
//        entity.setSignalizaciya(dto.getSignalizaciya());
//        entity.setVideomofon(dto.getVideomofon());
//        entity.setVideonablyudeniye(dto.getVideonablyudeniye());
//        entity.setKruglosutochnayaOhrana(dto.getKruglosutochnayaOhrana());
        return entity;
    }

}
