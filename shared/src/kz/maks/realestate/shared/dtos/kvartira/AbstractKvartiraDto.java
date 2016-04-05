package kz.maks.realestate.shared.dtos.kvartira;

import kz.maks.realestate.shared.dtos.AbstractKrishaAdDto;
import kz.maks.realestate.shared.refs.Internet;
import kz.maks.realestate.shared.refs.kvartira.*;

public abstract class AbstractKvartiraDto extends AbstractKrishaAdDto {
    protected Integer kolichestvoKomnat;
    protected Integer etazh;
    protected Integer etazhnost;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;
    protected Integer godPostroyki;
    protected TipStroyeniya tipStroyeniya;
    protected Integer kvartira;
    protected Sostoyaniye sostoyaniye;
    protected Planirovka planirovka;
    protected Telefon telefon;
    protected Sanuzel sanuzel;
    protected Balkon balkon;
    protected Dver dver;
    protected Pol pol;

//    protected String zhiloyKomplex;
//    protected Boolean isObwyaga;
//    protected Internet internet;
//    protected Parkovka parkovka;
//    protected Mebel mebel;
//    protected Double vysotaPotolkov;
//
//    protected Boolean reshetkiNaOknah;
//    protected Boolean ohrana;
//    protected Boolean domofon;
//    protected Boolean kodovyZamok;
//    protected Boolean signalizaciya;
//    protected Boolean videonablyudeniye;
//    protected Boolean videomofon;
//    protected Boolean konsyerzh;

    public Integer getKolichestvoKomnat() {
        return kolichestvoKomnat;
    }

    public void setKolichestvoKomnat(Integer kolichestvoKomnat) {
        this.kolichestvoKomnat = kolichestvoKomnat;
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

    public Integer getGodPostroyki() {
        return godPostroyki;
    }

    public void setGodPostroyki(Integer godPostroyki) {
        this.godPostroyki = godPostroyki;
    }

    public TipStroyeniya getTipStroyeniya() {
        return tipStroyeniya;
    }

    public void setTipStroyeniya(TipStroyeniya tipStroyeniya) {
        this.tipStroyeniya = tipStroyeniya;
    }

    public Integer getKvartira() {
        return kvartira;
    }

    public void setKvartira(Integer kvartira) {
        this.kvartira = kvartira;
    }

    public Sostoyaniye getSostoyaniye() {
        return sostoyaniye;
    }

    public void setSostoyaniye(Sostoyaniye sostoyaniye) {
        this.sostoyaniye = sostoyaniye;
    }

    public Planirovka getPlanirovka() {
        return planirovka;
    }

    public void setPlanirovka(Planirovka planirovka) {
        this.planirovka = planirovka;
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

    @Override
    public String toString() {
        return "AbstractKvartiraDto{" +
                "kolichestvoKomnat=" + kolichestvoKomnat +
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
                '}';
    }
}