package kz.maks.realestate.parser.entities;

import kz.maks.realestate.parser.entities.refs.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Audited
public abstract class AbstractDomEntity extends AbstractKrishaAdEntity {
    protected Integer kolichestvoKomnat;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected DomTipStroyeniya tipStroyeniya;
    protected Integer kolichestvoUrovney;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;
    protected Double ploshadUchastka;
    protected String kakOgorojen;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected DomSostoyaniye sostoyaniye;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected DomTelefon telefon;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Internet internet;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected DomSanuzel sanuzel;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Kanalizaciya kanalizaciya;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Voda voda;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Elektrichestvo elektrichestvo;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Otopleniye otopleniye;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
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

    public DomTipStroyeniya getTipStroyeniya() {
        return tipStroyeniya;
    }

    public void setTipStroyeniya(DomTipStroyeniya tipStroyeniya) {
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

    public DomSostoyaniye getSostoyaniye() {
        return sostoyaniye;
    }

    public void setSostoyaniye(DomSostoyaniye sostoyaniye) {
        this.sostoyaniye = sostoyaniye;
    }

    public DomTelefon getTelefon() {
        return telefon;
    }

    public void setTelefon(DomTelefon telefon) {
        this.telefon = telefon;
    }

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }

    public DomSanuzel getSanuzel() {
        return sanuzel;
    }

    public void setSanuzel(DomSanuzel sanuzel) {
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
