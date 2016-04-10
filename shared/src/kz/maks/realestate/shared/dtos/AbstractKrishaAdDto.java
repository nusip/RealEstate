package kz.maks.realestate.shared.dtos;

import kz.maks.core.shared.dtos.AbstractIdDto;
import kz.maks.realestate.shared.refs.IstochnikInfo;
import kz.maks.realestate.shared.refs.Valyuta;

import java.util.Date;
import java.util.List;

public abstract class AbstractKrishaAdDto extends AbstractIdDto {
    protected String krishaId;
    protected Boolean isArchive;
    protected Date createdAt;
    protected Date updatedAt;
    protected Double cena;
    protected Double cenaProdazhi;
    protected Long valyutaId;
    protected String valyuta;
    protected Long regionId;
    protected String region;
    protected String regionKrishaId;
    protected String ulica;
    protected String peresechenie;
    protected String dom;
    protected String raznoe;
    protected String primechanie;
    protected List<String> telNumbers;
    protected List<String> photoPaths;
    protected Long istochnikInfoId;
    protected String istochnikInfo;
    protected Long assignedToId;
    protected String assignedTo;
    protected Long modifiedById;
    protected String modifiedBy;

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

    public Long getValyutaId() {
        return valyutaId;
    }

    public void setValyutaId(Long valyutaId) {
        this.valyutaId = valyutaId;
    }

    public String getValyuta() {
        return valyuta;
    }

    public void setValyuta(String valyuta) {
        this.valyuta = valyuta;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public Long getIstochnikInfoId() {
        return istochnikInfoId;
    }

    public void setIstochnikInfoId(Long istochnikInfoId) {
        this.istochnikInfoId = istochnikInfoId;
    }

    public String getIstochnikInfo() {
        return istochnikInfo;
    }

    public void setIstochnikInfo(String istochnikInfo) {
        this.istochnikInfo = istochnikInfo;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public Long getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Long modifiedById) {
        this.modifiedById = modifiedById;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
