package kz.maks.realestate.shared.dtos.list.dom;

import kz.maks.realestate.shared.dtos.get.dom.AbstractDomGetDto;

public class DomSaleListDto extends AbstractDomListDto {
    private Boolean isZalog;

    public Boolean getIsZalog() {
        return isZalog;
    }

    public void setIsZalog(Boolean isZalog) {
        this.isZalog = isZalog;
    }
}
