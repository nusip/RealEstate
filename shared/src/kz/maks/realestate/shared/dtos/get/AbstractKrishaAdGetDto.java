package kz.maks.realestate.shared.dtos.get;

import kz.maks.core.shared.dtos.AbstractIdDto;
import kz.maks.realestate.shared.refs.IstochnikInfo;
import kz.maks.realestate.shared.refs.Valyuta;

import java.util.Date;
import java.util.List;

public abstract class AbstractKrishaAdGetDto extends AbstractIdDto {
    protected String krishaId;
    protected Boolean isArchive;
    protected Date createdAt;
    protected Date updatedAt;
    protected Double cena;
    protected Double cenaProdazhi;
    protected Valyuta valyuta;
    protected Long regionId;
    protected String regionKrishaId;
    protected String ulica;
    protected String peresechenie;
    protected String dom;
    protected String raznoe;
    protected String primechanie;
    protected List<String> telNumbers;
    protected List<String> photoPaths;
    protected IstochnikInfo istochnikInfo;
    protected Long assignedToId;

    public String getKrishaId() {
        return krishaId;
    }

    public void setKrishaId(String krishaId) {
        this.krishaId = krishaId;
    }

    public Boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Double getCenaProdazhi() {
        return cenaProdazhi;
    }

    public void setCenaProdazhi(Double cenaProdazhi) {
        this.cenaProdazhi = cenaProdazhi;
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
}
