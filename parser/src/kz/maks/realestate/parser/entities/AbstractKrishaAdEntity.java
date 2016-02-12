package kz.maks.realestate.parser.entities;

import kz.maks.core.back.entities.AbstractBaseEntity;
import kz.maks.realestate.shared.refs.Valyuta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class AbstractKrishaAdEntity extends AbstractKrishaEntity {
    protected BigDecimal cena;

    @Enumerated(EnumType.STRING)
    protected Valyuta valyuta;

    @ManyToOne
    protected Region region;
    protected String ulicaDom;

    @Column(length = 5000)
    protected String raznoe;

    @ElementCollection
    protected List<String> telNumbers = new ArrayList<>();

    @ElementCollection
    protected List<String> photoPaths = new ArrayList<>();

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
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

}
