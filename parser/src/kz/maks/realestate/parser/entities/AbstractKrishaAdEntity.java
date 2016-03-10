package kz.maks.realestate.parser.entities;

import kz.maks.realestate.shared.refs.IstochnikInfo;
import kz.maks.realestate.shared.refs.Valyuta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class AbstractKrishaAdEntity extends AbstractKrishaEntity {
    protected BigDecimal cena;
    protected BigDecimal cenaProdazhi;

    @Enumerated(EnumType.STRING)
    protected Valyuta valyuta;

    @ManyToOne
    protected Region region;
    protected String ulica;
    protected String peresechenie;
    protected String dom;

    protected Boolean isArchive;

    @Column(length = 5000)
    protected String raznoe;

    protected String primechanie;

    @ElementCollection
    protected List<String> telNumbers = new ArrayList<>();

    @ElementCollection
    protected List<String> photoPaths = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    protected IstochnikInfo istochnikInfo;

    @ManyToOne
    protected User assignedTo;

    @ManyToOne
    protected User modifiedBy;

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public BigDecimal getCenaProdazhi() {
        return cenaProdazhi;
    }

    public void setCenaProdazhi(BigDecimal cenaProdazhi) {
        this.cenaProdazhi = cenaProdazhi;
    }

    public Valyuta getValyuta() {
        return valyuta;
    }

    public void setValyuta(Valyuta valyuta) {
        this.valyuta = valyuta;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getPeresechenie() {
        return peresechenie;
    }

    public void setPeresechenie(String peresechenie) {
        this.peresechenie = peresechenie;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public Boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }

    public String getRaznoe() {
        return raznoe;
    }

    public void setRaznoe(String raznoe) {
        this.raznoe = raznoe;
    }

    public String getPrimechanie() {
        return primechanie;
    }

    public void setPrimechanie(String primechanie) {
        this.primechanie = primechanie;
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

    public IstochnikInfo getIstochnikInfo() {
        return istochnikInfo;
    }

    public void setIstochnikInfo(IstochnikInfo istochnikInfo) {
        this.istochnikInfo = istochnikInfo;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
