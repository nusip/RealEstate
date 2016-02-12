package kz.maks.realestate.parser.entities;

import kz.maks.realestate.shared.refs.Internet;
import kz.maks.realestate.shared.refs.kvartira.*;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractKvartiraEntity extends AbstractKrishaAdEntity {
    protected Integer kolichestvoKomnat;
    protected String zhiloyKomplex;

    @Enumerated(EnumType.STRING)
    protected TipStroyeniya tipStroyeniya;
    protected Integer godPostroyki;
    protected Integer etazh;
    protected Integer etazhnost;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;
    protected Boolean isObwyaga;

    @Enumerated(EnumType.STRING)
    protected Sostoyaniye sostoyaniye;
    @Enumerated(EnumType.STRING)
    protected Telefon telefon;
    @Enumerated(EnumType.STRING)
    protected Internet internet;
    @Enumerated(EnumType.STRING)
    protected Sanuzel sanuzel;
    @Enumerated(EnumType.STRING)
    protected Balkon balkon;
    @Enumerated(EnumType.STRING)
    protected Dver dver;
    @Enumerated(EnumType.STRING)
    protected Parkovka parkovka;
    @Enumerated(EnumType.STRING)
    protected Mebel mebel;
    @Enumerated(EnumType.STRING)
    protected Pol pol;

    protected Double vysotaPotolkov;

    protected Boolean reshetkiNaOknah;
    protected Boolean ohrana;
    protected Boolean domofon;
    protected Boolean kodovyZamok;
    protected Boolean signalizaciya;
    protected Boolean videonablyudeniye;
    protected Boolean videomofon;
    protected Boolean konsyerzh;

    public Integer getKolichestvoKomnat() {
        return kolichestvoKomnat;
    }

    public void setKolichestvoKomnat(Integer kolichestvoKomnat) {
        this.kolichestvoKomnat = kolichestvoKomnat;
    }

    public String getZhiloyKomplex() {
        return zhiloyKomplex;
    }

    public void setZhiloyKomplex(String zhiloyKomplex) {
        this.zhiloyKomplex = zhiloyKomplex;
    }

    public TipStroyeniya getTipStroyeniya() {
        return tipStroyeniya;
    }

    public void setTipStroyeniya(TipStroyeniya tipStroyeniya) {
        this.tipStroyeniya = tipStroyeniya;
    }

    public Integer getGodPostroyki() {
        return godPostroyki;
    }

    public void setGodPostroyki(Integer godPostroyki) {
        this.godPostroyki = godPostroyki;
    }

    public Integer getEtazh() {
        return etazh;
    }

    public void setEtazh(Integer etazh) {
        this.etazh = etazh;
    }

    public Integer getEtazhnost() {
        return etazhnost;
    }

    public void setEtazhnost(Integer etazhnost) {
        this.etazhnost = etazhnost;
    }

    public Double getPloshadObshaya() {
        return ploshadObshaya;
    }

    public void setPloshadObshaya(Double ploshadObshaya) {
        this.ploshadObshaya = ploshadObshaya;
    }

    public Double getPloshadZhilaya() {
        return ploshadZhilaya;
    }

    public void setPloshadZhilaya(Double ploshadZhilaya) {
        this.ploshadZhilaya = ploshadZhilaya;
    }

    public Double getPloshadKuhnya() {
        return ploshadKuhnya;
    }

    public void setPloshadKuhnya(Double ploshadKuhnya) {
        this.ploshadKuhnya = ploshadKuhnya;
    }

    public Boolean getIsObwyaga() {
        return isObwyaga;
    }

    public void setIsObwyaga(Boolean isObwyaga) {
        this.isObwyaga = isObwyaga;
    }

    public Sostoyaniye getSostoyaniye() {
        return sostoyaniye;
    }

    public void setSostoyaniye(Sostoyaniye sostoyaniye) {
        this.sostoyaniye = sostoyaniye;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }

    public Sanuzel getSanuzel() {
        return sanuzel;
    }

    public void setSanuzel(Sanuzel sanuzel) {
        this.sanuzel = sanuzel;
    }

    public Balkon getBalkon() {
        return balkon;
    }

    public void setBalkon(Balkon balkon) {
        this.balkon = balkon;
    }

    public Dver getDver() {
        return dver;
    }

    public void setDver(Dver dver) {
        this.dver = dver;
    }

    public Parkovka getParkovka() {
        return parkovka;
    }

    public void setParkovka(Parkovka parkovka) {
        this.parkovka = parkovka;
    }

    public Mebel getMebel() {
        return mebel;
    }

    public void setMebel(Mebel mebel) {
        this.mebel = mebel;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Double getVysotaPotolkov() {
        return vysotaPotolkov;
    }

    public void setVysotaPotolkov(Double vysotaPotolkov) {
        this.vysotaPotolkov = vysotaPotolkov;
    }

    public Boolean getReshetkiNaOknah() {
        return reshetkiNaOknah;
    }

    public void setReshetkiNaOknah(Boolean reshetkiNaOknah) {
        this.reshetkiNaOknah = reshetkiNaOknah;
    }

    public Boolean getOhrana() {
        return ohrana;
    }

    public void setOhrana(Boolean ohrana) {
        this.ohrana = ohrana;
    }

    public Boolean getDomofon() {
        return domofon;
    }

    public void setDomofon(Boolean domofon) {
        this.domofon = domofon;
    }

    public Boolean getKodovyZamok() {
        return kodovyZamok;
    }

    public void setKodovyZamok(Boolean kodovyZamok) {
        this.kodovyZamok = kodovyZamok;
    }

    public Boolean getSignalizaciya() {
        return signalizaciya;
    }

    public void setSignalizaciya(Boolean signalizaciya) {
        this.signalizaciya = signalizaciya;
    }

    public Boolean getVideonablyudeniye() {
        return videonablyudeniye;
    }

    public void setVideonablyudeniye(Boolean videonablyudeniye) {
        this.videonablyudeniye = videonablyudeniye;
    }

    public Boolean getVideomofon() {
        return videomofon;
    }

    public void setVideomofon(Boolean videomofon) {
        this.videomofon = videomofon;
    }

    public Boolean getKonsyerzh() {
        return konsyerzh;
    }

    public void setKonsyerzh(Boolean konsyerzh) {
        this.konsyerzh = konsyerzh;
    }

    @Override
    public String toString() {
        return "AbstractKvartiraEntity{" +
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
                '}';
    }
}
