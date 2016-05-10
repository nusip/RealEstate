package kz.maks.realestate.center.entities;

import kz.maks.core.back.entities.AbstractBaseEntity;
import kz.maks.core.shared.models.HasName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "client_seq")
public class Client extends AbstractBaseEntity implements HasName {
    @Column(unique = true, nullable = false)
    private String name;

    private Boolean isActive;

    @OneToMany(mappedBy = "client")
    private List<Device> devices = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Transient
    @Override
    public String name() {
        return getName();
    }
}
