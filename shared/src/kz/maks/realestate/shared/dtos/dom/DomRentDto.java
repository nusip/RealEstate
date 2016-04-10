package kz.maks.realestate.shared.dtos.dom;


public class DomRentDto extends AbstractDomDto {
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
