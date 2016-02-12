package kz.maks.realestate.shared.dtos.get;

import kz.maks.core.shared.dtos.AbstractIdDto;
import kz.maks.realestate.shared.refs.Valyuta;

import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractKrishaAdGetDto extends AbstractIdDto {
    protected String krishaId;
    protected Long updatedAt;
    protected Double cena;
    protected Valyuta valyuta;
    protected Long regionId;
    protected String regionKrishaId;
    protected String ulicaDom;
    protected String raznoe;
    protected List<String> telNumbers;
    protected List<String> photoPaths;

    public String getKrishaId() {
        return krishaId;
    }

    public void setKrishaId(String krishaId) {
        this.krishaId = krishaId;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Valyuta getValyuta() {
        return valyuta;
    }

    public void setValyuta(Valyuta valyuta) {
        this.valyuta = valyuta;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionKrishaId() {
        return regionKrishaId;
    }

    public void setRegionKrishaId(String regionKrishaId) {
        this.regionKrishaId = regionKrishaId;
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
