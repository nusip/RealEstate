package kz.maks.realestate.shared.dtos.kvartira;

public class KvartiraRentDto extends AbstractKvartiraDto {
    private Long kakSdayeteId;
    private String kakSdayete;

    public Long getKakSdayeteId() {
        return kakSdayeteId;
    }

    public void setKakSdayeteId(Long kakSdayeteId) {
        this.kakSdayeteId = kakSdayeteId;
    }

    public String getKakSdayete() {
        return kakSdayete;
    }

    public void setKakSdayete(String kakSdayete) {
        this.kakSdayete = kakSdayete;
    }
}
