package kz.maks.realestate.shared.dtos.dom;

import kz.maks.realestate.shared.dtos.AbstractKrishaAdDto;
import kz.maks.realestate.shared.refs.Internet;
import kz.maks.realestate.shared.refs.dom.*;

public abstract class AbstractDomDto extends AbstractKrishaAdDto {
    protected Integer kolichestvoKomnat;
    protected Long tipStroyeniyaId;
    protected String tipStroyeniya;
    protected Integer kolichestvoUrovney;
    protected Double ploshadObshaya;
    protected Double ploshadZhilaya;
    protected Double ploshadKuhnya;
    protected Double ploshadUchastka;
    protected String kakOgorojen;
    protected Long sostoyaniyeId;
    protected String sostoyaniye;
    protected Long telefonId;
    protected String telefon;
    protected Long internetId;
    protected String internet;
    protected Long sanuzelId;
    protected String sanuzel;
    protected Long kanalizaciyaId;
    protected String kanalizaciya;
    protected Long vodaId;
    protected String voda;
    protected Long elektrichestvoId;
    protected String elektrichestvo;
    protected Long otopleniyeId;
    protected String otopleniye;
    protected Long gazId;
    protected String gaz;
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

    public Long getInternetId() {
        return internetId;
    }

    public void setInternetId(Long internetId) {
        this.internetId = internetId;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
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

    public Long getKanalizaciyaId() {
        return kanalizaciyaId;
    }

    public void setKanalizaciyaId(Long kanalizaciyaId) {
        this.kanalizaciyaId = kanalizaciyaId;
    }

    public String getKanalizaciya() {
        return kanalizaciya;
    }

    public void setKanalizaciya(String kanalizaciya) {
        this.kanalizaciya = kanalizaciya;
    }

    public Long getVodaId() {
        return vodaId;
    }

    public void setVodaId(Long vodaId) {
        this.vodaId = vodaId;
    }

    public String getVoda() {
        return voda;
    }

    public void setVoda(String voda) {
        this.voda = voda;
    }

    public Long getElektrichestvoId() {
        return elektrichestvoId;
    }

    public void setElektrichestvoId(Long elektrichestvoId) {
        this.elektrichestvoId = elektrichestvoId;
    }

    public String getElektrichestvo() {
        return elektrichestvo;
    }

    public void setElektrichestvo(String elektrichestvo) {
        this.elektrichestvo = elektrichestvo;
    }

    public Long getOtopleniyeId() {
        return otopleniyeId;
    }

    public void setOtopleniyeId(Long otopleniyeId) {
        this.otopleniyeId = otopleniyeId;
    }

    public String getOtopleniye() {
        return otopleniye;
    }

    public void setOtopleniye(String otopleniye) {
        this.otopleniye = otopleniye;
    }

    public Long getGazId() {
        return gazId;
    }

    public void setGazId(Long gazId) {
        this.gazId = gazId;
    }

    public String getGaz() {
        return gaz;
    }

    public void setGaz(String gaz) {
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