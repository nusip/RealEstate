package kz.maks.realestate.shared.dtos.dom;

import kz.maks.realestate.shared.refs.KakSdayete;

public class DomRentDto extends AbstractDomDto {
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
