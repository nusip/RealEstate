package kz.maks.realestate.parser.entities;

import kz.maks.realestate.shared.refs.KakSdayete;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class KvartiraRent extends AbstractKvartiraEntity {
    @Enumerated(EnumType.STRING)
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
