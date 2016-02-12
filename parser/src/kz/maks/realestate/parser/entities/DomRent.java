package kz.maks.realestate.parser.entities;

import kz.maks.realestate.shared.refs.KakSdayete;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class DomRent extends AbstractDomEntity {
    @Enumerated(EnumType.STRING)
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
