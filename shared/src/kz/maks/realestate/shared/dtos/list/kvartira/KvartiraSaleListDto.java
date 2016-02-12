package kz.maks.realestate.shared.dtos.list.kvartira;

public class KvartiraSaleListDto extends AbstractKvartiraListDto {
    private Boolean isZalog;

    public Boolean getIsZalog() {
        return isZalog;
    }

    public void setIsZalog(Boolean isZalog) {
        this.isZalog = isZalog;
    }
}
