package kz.maks.realestate.shared.dtos.kvartira;

import kz.maks.realestate.shared.refs.KakSdayete;

public class KvartiraRentDto extends AbstractKvartiraDto {
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
