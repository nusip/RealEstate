package kz.maks.realestate.parser.entities;

import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@Audited
@SequenceGenerator(name = "id_gen", sequenceName = "kvartira_sale_seq")
public class KvartiraSale extends AbstractKvartiraEntity {
    private Boolean isZalog;

    public Boolean getIsZalog() {
        return isZalog;
    }

    public void setIsZalog(Boolean isZalog) {
        this.isZalog = isZalog;
    }

    @Override
    public String toString() {
        return "KvartiraSale{" +
                "kolichestvoKomnat=" + kolichestvoKomnat +
                ", cena=" + cena +
                ", valyutaId=" + valyuta +
                ", region='" + region + '\'' +
                ", ulica='" + ulica + '\'' +
                ", tipStroyeniya=" + tipStroyeniya +
                ", godPostroyki=" + godPostroyki +
                ", etazh=" + etazh +
                ", etazhnost=" + etazhnost +
                ", ploshadObshaya=" + ploshadObshaya +
                ", ploshadZhilaya=" + ploshadZhilaya +
                ", ploshadKuhnya=" + ploshadKuhnya +
                ", sostoyaniye=" + sostoyaniye +
                ", telefon=" + telefon +
                ", sanuzel=" + sanuzel +
                ", balkon=" + balkon +
                ", dver=" + dver +
                ", pol=" + pol +
                ", raznoe='" + raznoe + '\'' +
                ", telNumbers=" + telNumbers +
                ", photoPaths=" + photoPaths +
                ", isZalog=" + isZalog +
                '}';
    }
}
