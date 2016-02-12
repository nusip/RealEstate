package kz.maks.realestate.shared.dtos.get.kvartira;

public class KvartiraSaleGetDto extends AbstractKvartiraGetDto {
    private Boolean isZalog;

    public Boolean getIsZalog() {
        return isZalog;
    }

    public void setIsZalog(Boolean isZalog) {
        this.isZalog = isZalog;
    }

    @Override
    public String toString() {
        return "AbstractKvartiraGetDto{" +
                "kolichestvoKomnat=" + kolichestvoKomnat +
                ", zhiloyKomplex='" + zhiloyKomplex + '\'' +
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
                ", isZalog=" + isZalog +
                '}';
    }
}
