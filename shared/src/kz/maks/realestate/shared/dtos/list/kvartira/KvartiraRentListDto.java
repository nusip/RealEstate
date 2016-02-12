package kz.maks.realestate.shared.dtos.list.kvartira;

import kz.maks.realestate.shared.refs.KakSdayete;

public class KvartiraRentListDto extends AbstractKvartiraListDto {
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
