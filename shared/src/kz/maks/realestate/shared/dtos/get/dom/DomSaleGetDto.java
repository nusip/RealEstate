package kz.maks.realestate.shared.dtos.get.dom;

public class DomSaleGetDto extends AbstractDomGetDto {
    private Boolean isZalog;

    public Boolean getIsZalog() {
        return isZalog;
    }

    public void setIsZalog(Boolean isZalog) {
        this.isZalog = isZalog;
    }
}
