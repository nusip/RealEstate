package kz.maks.realestate.shared.dtos.get.kvartira;

import kz.maks.realestate.shared.refs.KakSdayete;

public class KvartiraRentGetDto extends AbstractKvartiraGetDto {
    private KakSdayete kakSdayete;

    public KakSdayete getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(KakSdayete kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
