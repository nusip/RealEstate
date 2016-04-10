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
    protected Long tipStroyeniyaId;
    protected String tipStroyeniya;
    protected Integer kvartira;
    protected Long sostoyaniyeId;
    protected String sostoyaniye;
    protected Long planirovkaId;
    protected String planirovka;
    protected Long telefonId;
    protected String telefon;
    protected Long sanuzelId;
    protected String sanuzel;
    protected Long balkonId;
    protected String balkon;
    protected Long dverId;
    protected String dver;
    protected Long polId;
    protected String pol;

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

    public Long getTipStroyeniyaId() {
        return tipStroyeniyaId;
    }

    public void setTipStroyeniyaId(Long tipStroyeniyaId) {
        this.tipStroyeniyaId = tipStroyeniyaId;
    }

    public String getTipStroyeniya() {
        return tipStroyeniya;
    }

    public void setTipStroyeniya(String tipStroyeniya) {
        this.tipStroyeniya = tipStroyeniya;
    }

    public Integer getKvartira() {
        return kvartira;
    }

    public void setKvartira(Integer kvartira) {
        this.kvartira = kvartira;
    }

    public Long getSostoyaniyeId() {
        return sostoyaniyeId;
    }

    public void setSostoyaniyeId(Long sostoyaniyeId) {
        this.sostoyaniyeId = sostoyaniyeId;
    }

    public String getSostoyaniye() {
        return sostoyaniye;
    }

    public void setSostoyaniye(String sostoyaniye) {
        this.sostoyaniye = sostoyaniye;
    }

    public Long getPlanirovkaId() {
        return planirovkaId;
    }

    public void setPlanirovkaId(Long planirovkaId) {
        this.planirovkaId = planirovkaId;
    }

    public String getPlanirovka() {
        return planirovka;
    }

    public void setPlanirovka(String planirovka) {
        this.planirovka = planirovka;
    }

    public Long getTelefonId() {
        return telefonId;
    }

    public void setTelefonId(Long telefonId) {
        this.telefonId = telefonId;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Long getSanuzelId() {
        return sanuzelId;
    }

    public void setSanuzelId(Long sanuzelId) {
        this.sanuzelId = sanuzelId;
    }

    public String getSanuzel() {
        return sanuzel;
    }

    public void setSanuzel(String sanuzel) {
        this.sanuzel = sanuzel;
    }

    public Long getBalkonId() {
        return balkonId;
    }

    public void setBalkonId(Long balkonId) {
        this.balkonId = balkonId;
    }

    public String getBalkon() {
        return balkon;
    }

    public void setBalkon(String balkon) {
        this.balkon = balkon;
    }

    public Long getDverId() {
        return dverId;
    }

    public void setDverId(Long dverId) {
        this.dverId = dverId;
    }

    public String getDver() {
        return dver;
    }

    public void setDver(String dver) {
        this.dver = dver;
    }

    public Long getPolId() {
        return polId;
    }

    public void setPolId(Long polId) {
        this.polId = polId;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
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