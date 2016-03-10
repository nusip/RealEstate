package kz.maks.realestate.shared.dtos.list.kvartira;

import kz.maks.core.shared.dtos.AbstractIdDto;
import kz.maks.realestate.shared.refs.*;
import kz.maks.realestate.shared.refs.kvartira.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class AbstractKvartiraListDto extends AbstractIdDto {
    protected Date createdAt;
    protected Integer kolichestvoKomnat;
    protected BigDecimal cena;
    protected Valyuta valyuta;

    protected String region;

    protected String zhiloyKomplex;
    protected String ulica;

    protected TipStroyeniya tipStroyeniya;
    protected Integer godPostroyki;
    protected Integer etazh;
    protected Integer etazhnost;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;
    protected Boolean isObwyaga;

    protected Sostoyaniye sostoyaniye;
    protected Telefon telefon;
    protected Internet internet;
    protected Sanuzel sanuzel;
    protected Balkon balkon;
    protected Dver dver;
    protected Parkovka parkovka;
    protected Mebel mebel;
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

    protected String raznoe;

    protected List<String> telNumbers;
    protected List<String> photoPaths;

    protected Planirovka planirovka;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getKolichestvoKomnat() {
        return kolichestvoKomnat;
    }

    public void setKolichestvoKomnat(Integer kolichestvoKomnat) {
        this.kolichestvoKomnat = kolichestvoKomnat;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public Valyuta getValyuta() {
        return valyuta;
    }

    public void setValyuta(Valyuta valyuta) {
        this.valyuta = valyuta;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZhiloyKomplex() {
        return zhiloyKomplex;
    }

    public void setZhiloyKomplex(String zhiloyKomplex) {
        this.zhiloyKomplex = zhiloyKomplex;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
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

    public String getRaznoe() {
        return raznoe;
    }

    public void setRaznoe(String raznoe) {
        this.raznoe = raznoe;
    }

    public List<String> getTelNumbers() {
        return telNumbers;
    }

    public void setTelNumbers(List<String> telNumbers) {
        this.telNumbers = telNumbers;
    }

    public List<String> getPhotoPaths() {
        return photoPaths;
    }

    public void setPhotoPaths(List<String> photoPaths) {
        this.photoPaths = photoPaths;
    }

    public Planirovka getPlanirovka() {
        return planirovka;
    }

    public void setPlanirovka(Planirovka planirovka) {
        this.planirovka = planirovka;
    }
}
