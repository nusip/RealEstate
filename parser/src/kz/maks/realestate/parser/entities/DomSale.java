package kz.maks.realestate.parser.entities;

import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@Audited
@SequenceGenerator(name = "id_gen", sequenceName = "dom_sale_seq")
public class DomSale extends AbstractDomEntity {
    private Boolean isZalog;

    public Boolean getIsZalog() {
        return isZalog;
    }

    public void setIsZalog(Boolean isZalog) {
        this.isZalog = isZalog;
    }
}
