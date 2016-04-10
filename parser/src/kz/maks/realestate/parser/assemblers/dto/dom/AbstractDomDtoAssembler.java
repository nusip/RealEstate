package kz.maks.realestate.parser.assemblers.dto.dom;

import kz.maks.core.shared.Utils;
import kz.maks.realestate.parser.assemblers.dto.AbstractKrishaAdDtoAssembler;
import kz.maks.realestate.parser.entities.AbstractDomEntity;
import kz.maks.realestate.shared.dtos.dom.AbstractDomDto;

import static kz.maks.core.shared.Utils.extractId;
import static kz.maks.core.shared.Utils.extractTitle;

public abstract class AbstractDomDtoAssembler<ENTITY extends AbstractDomEntity, DTO extends AbstractDomDto>
        extends AbstractKrishaAdDtoAssembler<ENTITY, DTO> {

    @Override
    public DTO assemble(ENTITY entity, DTO dto) {
        dto = super.assemble(entity, dto);
        dto.setKolichestvoKomnat(entity.getKolichestvoKomnat());
        dto.setTipStroyeniyaId(extractId(entity.getTipStroyeniya()));
        dto.setTipStroyeniya(entity.getTipStroyeniya() != null ? entity.getTipStroyeniya().getTitle() : null);
        dto.setKolichestvoUrovney(entity.getKolichestvoUrovney());
        dto.setPloshadObshaya(entity.getPloshadObshaya());
        dto.setPloshadZhilaya(entity.getPloshadZhilaya());
        dto.setPloshadKuhnya(entity.getPloshadKuhnya());
        dto.setPloshadUchastka(entity.getPloshadUchastka());
        dto.setKakOgorojen(entity.getKakOgorojen());
        dto.setSostoyaniyeId(extractId(entity.getSostoyaniye()));
        dto.setSostoyaniye(entity.getSostoyaniye() != null ? entity.getSostoyaniye().getTitle() : null);
        dto.setTelefonId(extractId(entity.getTelefon()));
        dto.setTelefon(entity.getTelefon() != null ? entity.getTelefon().getTitle() : null);
        dto.setInternetId(extractId(entity.getInternet()));
        dto.setInternet(entity.getInternet() != null ? entity.getInternet().getTitle() : null);
        dto.setSanuzelId(extractId(entity.getSanuzel()));
        dto.setSanuzel(entity.getSanuzel() != null ? entity.getSanuzel().getTitle() : null);
        dto.setKanalizaciyaId(extractId(entity.getKanalizaciya()));
        dto.setKanalizaciya(extractTitle(entity.getKanalizaciya()));
        dto.setVodaId(extractId(entity.getVoda()));
        dto.setVoda(extractTitle(entity.getVoda()));
        dto.setElektrichestvoId(extractId(entity.getElektrichestvo()));
        dto.setElektrichestvo(extractTitle(entity.getElektrichestvo()));
        dto.setOtopleniyeId(extractId(entity.getOtopleniye()));
        dto.setOtopleniye(extractTitle(entity.getOtopleniye()));
        dto.setGazId(extractId(entity.getGaz()));
        dto.setGaz(extractTitle(entity.getGaz()));
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
