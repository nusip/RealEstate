package kz.maks.realestate.parser.entities;

import kz.maks.core.back.entities.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractKrishaEntity extends AbstractBaseEntity {

    @Column(unique = true)
    protected String krishaId;

    /**
     * create or update time from krisha in millis
     */
    protected Long updatedAt;

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
}
