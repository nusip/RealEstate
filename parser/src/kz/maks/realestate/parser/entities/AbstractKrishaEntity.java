package kz.maks.realestate.parser.entities;

import kz.maks.core.back.entities.AbstractBaseEntity;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Audited
public abstract class AbstractKrishaEntity extends AbstractBaseEntity {

    @Column(unique = true)
    protected String krishaId;

    protected Date createdAt;

    protected Date updatedAt;

    public String getKrishaId() {
        return krishaId;
    }

    public void setKrishaId(String krishaId) {
        this.krishaId = krishaId;
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
}
