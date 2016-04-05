package kz.maks.realestate.parser.entities;

import kz.maks.realestate.shared.refs.kvartira.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@MappedSuperclass
@Audited
public abstract class AbstractKvartiraEntity extends AbstractKrishaAdEntity {
    protected Integer kolichestvoKomnat;

    @Enumerated(EnumType.STRING)
    protected TipStroyeniya tipStroyeniya;
    protected Integer godPostroyki;
    protected Integer etazh;
    protected Integer etazhnost;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;

    @Enumerated(EnumType.STRING)
    protected Sostoyaniye sostoyaniye;
    @Enumerated(EnumType.STRING)
    protected Telefon telefon;

    @Enumerated(EnumType.STRING)
    protected Sanuzel sanuzel;
    @Enumerated(EnumType.STRING)
    protected Balkon balkon;
    @Enumerated(EnumType.STRING)
    protected Dver dver;
    @Enumerated(EnumType.STRING)
    protected Pol pol;
    protected Integer kvartira;
    @Enumerated(EnumType.STRING)
    protected Planirovka planirovka;

//    protected Boolean isObwyaga;
//    @Enumerated(EnumType.STRING)
//    protected Internet internet;
//    @Enumerated(EnumType.STRING)
//    protected Parkovka parkovka;
//    @Enumerated(EnumType.STRING)
//    protected Mebel mebel;
//    protected Double vysotaPotolkov;

//    protected Boolean reshetkiNaOknah;
//    protected Boolean ohrana;
//    protected Boolean domofon;
//    protected Boolean kodovyZamok;
//    protected Boolean signalizaciya;
//    protected Boolean videonablyudeniye;
//    protected Boolean videomofon;
//    protected Boolean konsyerzh;

//    protected String zhiloyKomplex;

    public Integer getKolichestvoKomnat() {
        return kolichestvoKomnat;
    }

    public void setKolichestvoKomnat(Integer kolichestvoKomnat) {
        this.kolichestvoKomnat = kolichestvoKomnat;
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

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Integer getKvartira() {
        return kvartira;
    }

    public void setKvartira(Integer kvartira) {
        this.kvartira = kvartira;
    }

    public Planirovka getPlanirovka() {
        return planirovka;
    }

    public void setPlanirovka(Planirovka planirovka) {
        this.planirovka = planirovka;
    }

    @Override
    public String toString() {
        return "AbstractKvartiraEntity{" +
                "kolichestvoKomnat=" + kolichestvoKomnat +
                ", cena=" + cena +
                ", valyuta=" + valyuta +
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
                '}';
    }
}
