package kz.maks.realestate.center.entities;

import kz.maks.core.back.entities.AbstractBaseEntity;
import kz.maks.core.shared.models.HasTitle;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "device_seq")
public class Device extends AbstractBaseEntity implements HasTitle {
    @ManyToOne(optional = false)
    private Client client;

    /**
     * store device unique id like MAC address
     */
    @Column(unique = true, nullable = false)
    private String number;

    private Boolean isActive;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Transient
    @Override
    public String getTitle() {
        return getNumber();
    }
}
