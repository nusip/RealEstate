package kz.maks.realestate.parser.entities;

import kz.maks.realestate.parser.entities.refs.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@MappedSuperclass
@Audited
public abstract class AbstractKvartiraEntity extends AbstractKrishaAdEntity {
    protected Integer kolichestvoKomnat;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected KvartiraTipStroyeniya tipStroyeniya;
    protected Integer godPostroyki;
    protected Integer etazh;
    protected Integer etazhnost;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected KvartiraSostoyaniye sostoyaniye;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected KvartiraTelefon telefon;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected KvartiraSanuzel sanuzel;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Balkon balkon;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Dver dver;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected Pol pol;
    protected Integer kvartira;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
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

    public KvartiraTipStroyeniya getTipStroyeniya() {
        return tipStroyeniya;
    }

    public void setTipStroyeniya(KvartiraTipStroyeniya tipStroyeniya) {
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

    public KvartiraSostoyaniye getSostoyaniye() {
        return sostoyaniye;
    }

    public void setSostoyaniye(KvartiraSostoyaniye sostoyaniye) {
        this.sostoyaniye = sostoyaniye;
    }

    public KvartiraTelefon getTelefon() {
        return telefon;
    }

    public void setTelefon(KvartiraTelefon telefon) {
        this.telefon = telefon;
    }

    public KvartiraSanuzel getSanuzel() {
        return sanuzel;
    }

    public void setSanuzel(KvartiraSanuzel sanuzel) {
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
                ", valyutaId=" + valyuta +
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
