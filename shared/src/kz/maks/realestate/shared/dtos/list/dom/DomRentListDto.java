package kz.maks.realestate.shared.dtos.list.dom;

import kz.maks.realestate.shared.dtos.get.dom.AbstractDomGetDto;
import kz.maks.realestate.shared.refs.KakSdayete;

public class DomRentListDto extends AbstractDomListDto {
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
