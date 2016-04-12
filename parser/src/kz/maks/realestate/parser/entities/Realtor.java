package kz.maks.realestate.parser.entities;

import kz.maks.core.back.entities.AbstractBaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Realtor extends AbstractKrishaEntity {
    private String name;
    private String company;
    private String vidDeyatelnosti;
    @ElementCollection
    private List<String> telNumbers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVidDeyatelnosti() {
        return vidDeyatelnosti;
    }

    public void setVidDeyatelnosti(String vidDeyatelnosti) {
        this.vidDeyatelnosti = vidDeyatelnosti;
    }

    public List<String> getTelNumbers() {
        return telNumbers;
    }

    public void setTelNumbers(List<String> telNumbers) {
        this.telNumbers = telNumbers;
    }
}
