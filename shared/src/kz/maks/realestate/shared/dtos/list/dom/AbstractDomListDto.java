package kz.maks.realestate.shared.dtos.list.dom;

import kz.maks.core.shared.dtos.AbstractIdDto;
import kz.maks.realestate.shared.refs.Internet;
import kz.maks.realestate.shared.refs.Valyuta;
import kz.maks.realestate.shared.refs.dom.*;

import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractDomListDto extends AbstractIdDto {
    protected BigDecimal cena;
    protected Valyuta valyuta;
    protected String region;
    protected String ulicaDom;
    protected String raznoe;
    protected List<String> telNumbers;
    protected List<String> photoPaths;

    protected Integer kolichestvoKomnat;
    protected TipStroyeniya tipStroyeniya;
    protected Integer kolichestvoUrovney;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;
    protected Double ploshadUchastka;
    protected String kakOgorojen;
    protected Sostoyaniye sostoyaniye;
    protected Telefon telefon;
    protected Internet internet;
    protected Sanuzel sanuzel;
    protected Kanalizaciya kanalizaciya;
    protected Voda voda;
    protected Elektrichestvo elektrichestvo;
    protected Otopleniye otopleniye;
    protected Gaz gaz;
    protected String pokrytieKryshi;
    protected Double vysotaPotolkov;

    protected Boolean reshetkiNaOknah;
    protected Boolean domofon;
    protected Boolean signalizaciya;
    protected Boolean videomofon;
    protected Boolean videonablyudeniye;
    protected Boolean kruglosutochnayaOhrana;

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

    public String getUlicaDom() {
        return ulicaDom;
    }

    public void setUlicaDom(String ulicaDom) {
        this.ulicaDom = ulicaDom;
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

    public Integer getKolichestvoUrovney() {
        return kolichestvoUrovney;
    }

    public void setKolichestvoUrovney(Integer kolichestvoUrovney) {
        this.kolichestvoUrovney = kolichestvoUrovney;
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

    public Double getPloshadUchastka() {
        return ploshadUchastka;
    }

    public void setPloshadUchastka(Double ploshadUchastka) {
        this.ploshadUchastka = ploshadUchastka;
    }

    public String getKakOgorojen() {
        return kakOgorojen;
    }

    public void setKakOgorojen(String kakOgorojen) {
        this.kakOgorojen = kakOgorojen;
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

    public Kanalizaciya getKanalizaciya() {
        return kanalizaciya;
    }

    public void setKanalizaciya(Kanalizaciya kanalizaciya) {
        this.kanalizaciya = kanalizaciya;
    }

    public Voda getVoda() {
        return voda;
    }

    public void setVoda(Voda voda) {
        this.voda = voda;
    }

    public Elektrichestvo getElektrichestvo() {
        return elektrichestvo;
    }

    public void setElektrichestvo(Elektrichestvo elektrichestvo) {
        this.elektrichestvo = elektrichestvo;
    }

    public Otopleniye getOtopleniye() {
        return otopleniye;
    }

    public void setOtopleniye(Otopleniye otopleniye) {
        this.otopleniye = otopleniye;
    }

    public Gaz getGaz() {
        return gaz;
    }

    public void setGaz(Gaz gaz) {
        this.gaz = gaz;
    }

    public String getPokrytieKryshi() {
        return pokrytieKryshi;
    }

    public void setPokrytieKryshi(String pokrytieKryshi) {
        this.pokrytieKryshi = pokrytieKryshi;
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

    public Boolean getDomofon() {
        return domofon;
    }

    public void setDomofon(Boolean domofon) {
        this.domofon = domofon;
    }

    public Boolean getSignalizaciya() {
        return signalizaciya;
    }

    public void setSignalizaciya(Boolean signalizaciya) {
        this.signalizaciya = signalizaciya;
    }

    public Boolean getVideomofon() {
        return videomofon;
    }

    public void setVideomofon(Boolean videomofon) {
        this.videomofon = videomofon;
    }

    public Boolean getVideonablyudeniye() {
        return videonablyudeniye;
    }

    public void setVideonablyudeniye(Boolean videonablyudeniye) {
        this.videonablyudeniye = videonablyudeniye;
    }

    public Boolean getKruglosutochnayaOhrana() {
        return kruglosutochnayaOhrana;
    }

    public void setKruglosutochnayaOhrana(Boolean kruglosutochnayaOhrana) {
        this.kruglosutochnayaOhrana = kruglosutochnayaOhrana;
    }
}
