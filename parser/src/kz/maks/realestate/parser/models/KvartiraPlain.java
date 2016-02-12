package kz.maks.realestate.parser.models;

import java.io.Serializable;
import java.util.List;

public class KvartiraPlain implements Serializable {
    private String krishaId;
    private String title;
    private String price;
    private String subtitle;
    private String zalog;
    private String dom;
    private String godPostroiki;
    private String zhiloyKomplex;
    private String etaj;
    private String ploshad;
    private String sostoyanie;
    private String sanuzel;
    private String balkon;
    private String dver;
    private String telefon;
    private String internet;
    private String parkovka;
    private String mebel;
    private String pol;
    private String potolki;
    private String bezopasnost;
    private String obwyaga;
    private String raznoe;
    private String nomer;
    private List<String> imageUrls;

    public String getKrishaId() {
        return krishaId;
    }

    public void setKrishaId(String krishaId) {
        this.krishaId = krishaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getZalog() {
        return zalog;
    }

    public void setZalog(String zalog) {
        this.zalog = zalog;
    }

    public String getDom() {
        return dom;
    }

    public String getGodPostroiki() {
        return godPostroiki;
    }

    public void setGodPostroiki(String godPostroiki) {
        this.godPostroiki = godPostroiki;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getZhiloyKomplex() {
        return zhiloyKomplex;
    }

    public void setZhiloyKomplex(String zhiloyKomplex) {
        this.zhiloyKomplex = zhiloyKomplex;
    }

    public String getEtaj() {
        return etaj;
    }

    public void setEtaj(String etaj) {
        this.etaj = etaj;
    }

    public String getPloshad() {
        return ploshad;
    }

    public void setPloshad(String ploshad) {
        this.ploshad = ploshad;
    }

    public String getSostoyanie() {
        return sostoyanie;
    }

    public void setSostoyanie(String sostoyanie) {
        this.sostoyanie = sostoyanie;
    }

    public String getSanuzel() {
        return sanuzel;
    }

    public void setSanuzel(String sanuzel) {
        this.sanuzel = sanuzel;
    }

    public String getBalkon() {
        return balkon;
    }

    public void setBalkon(String balkon) {
        this.balkon = balkon;
    }

    public String getDver() {
        return dver;
    }

    public void setDver(String dver) {
        this.dver = dver;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getParkovka() {
        return parkovka;
    }

    public void setParkovka(String parkovka) {
        this.parkovka = parkovka;
    }

    public String getMebel() {
        return mebel;
    }

    public void setMebel(String mebel) {
        this.mebel = mebel;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getPotolki() {
        return potolki;
    }

    public void setPotolki(String potolki) {
        this.potolki = potolki;
    }

    public String getBezopasnost() {
        return bezopasnost;
    }

    public void setBezopasnost(String bezopasnost) {
        this.bezopasnost = bezopasnost;
    }

    public String getObwyaga() {
        return obwyaga;
    }

    public void setObwyaga(String obwyaga) {
        this.obwyaga = obwyaga;
    }

    public String getRaznoe() {
        return raznoe;
    }

    public void setRaznoe(String raznoe) {
        this.raznoe = raznoe;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "KvartiraPlain{" +
                "krishaId='" + krishaId + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", zalog='" + zalog + '\'' +
                ", dom='" + dom + '\'' +
                ", godPostroiki='" + godPostroiki + '\'' +
                ", zhiloyKomplex='" + zhiloyKomplex + '\'' +
                ", etaj='" + etaj + '\'' +
                ", ploshad='" + ploshad + '\'' +
                ", sostoyanie='" + sostoyanie + '\'' +
                ", sanuzel='" + sanuzel + '\'' +
                ", balkon='" + balkon + '\'' +
                ", dver='" + dver + '\'' +
                ", telefon='" + telefon + '\'' +
                ", internet='" + internet + '\'' +
                ", parkovka='" + parkovka + '\'' +
                ", mebel='" + mebel + '\'' +
                ", pol='" + pol + '\'' +
                ", potolki='" + potolki + '\'' +
                ", bezopasnost='" + bezopasnost + '\'' +
                ", obwyaga='" + obwyaga + '\'' +
                ", raznoe='" + raznoe + '\'' +
                ", nomer='" + nomer + '\'' +
                ", imageUrls=" + imageUrls +
                '}';
    }
}