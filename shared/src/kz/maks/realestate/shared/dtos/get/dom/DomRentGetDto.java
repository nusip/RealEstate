package kz.maks.realestate.shared.dtos.get.dom;

import kz.maks.realestate.shared.refs.KakSdayete;

public class DomRentGetDto extends AbstractDomGetDto {
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
