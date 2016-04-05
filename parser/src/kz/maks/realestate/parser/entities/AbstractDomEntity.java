package kz.maks.realestate.parser.entities;

import kz.maks.realestate.shared.refs.Internet;
import kz.maks.realestate.shared.refs.dom.*;
import org.hibernate.envers.Audited;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Audited
public abstract class AbstractDomEntity extends AbstractKrishaAdEntity {
    protected Integer kolichestvoKomnat;
    @Enumerated(EnumType.STRING)
    protected TipStroyeniya tipStroyeniya;
    protected Integer kolichestvoUrovney;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;
    protected Double ploshadUchastka;
    protected String kakOgorojen;
    @Enumerated(EnumType.STRING)
    protected Sostoyaniye sostoyaniye;
    @Enumerated(EnumType.STRING)
    protected Telefon telefon;
    @Enumerated(EnumType.STRING)
    protected Internet internet;
    @Enumerated(EnumType.STRING)
    protected Sanuzel sanuzel;
    @Enumerated(EnumType.STRING)
    protected Kanalizaciya kanalizaciya;
    @Enumerated(EnumType.STRING)
    protected Voda voda;
    @Enumerated(EnumType.STRING)
    protected Elektrichestvo elektrichestvo;
    @Enumerated(EnumType.STRING)
    protected Otopleniye otopleniye;
    @Enumerated(EnumType.STRING)
    protected Gaz gaz;
    protected String pokrytieKryshi;
    protected Double vysotaPotolkov;

//    protected Boolean reshetkiNaOknah;
//    protected Boolean domofon;
//    protected Boolean signalizaciya;
//    protected Boolean videomofon;
//    protected Boolean videonablyudeniye;
//    protected Boolean kruglosutochnayaOhrana;

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
}
