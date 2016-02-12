package kz.maks.realestate.parser.entities;

import javax.persistence.Entity;

@Entity
public class DomSale extends AbstractDomEntity {
    private Boolean isZalog;

    public Boolean getIsZalog() {
        return isZalog;
    }

    public void setIsZalog(Boolean isZalog) {
        this.isZalog = isZalog;
    }
}
