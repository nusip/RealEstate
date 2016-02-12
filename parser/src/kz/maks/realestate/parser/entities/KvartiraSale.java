package kz.maks.realestate.parser.entities;

import javax.persistence.Entity;

@Entity
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
                ", valyuta=" + valyuta +
                ", region='" + region + '\'' +
                ", zhiloyKomplex='" + zhiloyKomplex + '\'' +
                ", ulicaDom='" + ulicaDom + '\'' +
                ", tipStroyeniya=" + tipStroyeniya +
                ", godPostroyki=" + godPostroyki +
                ", etazh=" + etazh +
                ", etazhnost=" + etazhnost +
                ", ploshadObshaya=" + ploshadObshaya +
                ", ploshadZhilaya=" + ploshadZhilaya +
                ", ploshadKuhnya=" + ploshadKuhnya +
                ", isObwyaga=" + isObwyaga +
                ", sostoyaniye=" + sostoyaniye +
                ", telefon=" + telefon +
                ", internet=" + internet +
                ", sanuzel=" + sanuzel +
                ", balkon=" + balkon +
                ", dver=" + dver +
                ", parkovka=" + parkovka +
                ", mebel=" + mebel +
                ", pol=" + pol +
                ", vysotaPotolkov=" + vysotaPotolkov +
                ", reshetkiNaOknah=" + reshetkiNaOknah +
                ", ohrana=" + ohrana +
                ", domofon=" + domofon +
                ", kodovyZamok=" + kodovyZamok +
                ", signalizaciya=" + signalizaciya +
                ", videonablyudeniye=" + videonablyudeniye +
                ", videomofon=" + videomofon +
                ", konsyerzh=" + konsyerzh +
                ", raznoe='" + raznoe + '\'' +
                ", telNumbers=" + telNumbers +
                ", photoPaths=" + photoPaths +
                ", isZalog=" + isZalog +
                '}';
    }
}
