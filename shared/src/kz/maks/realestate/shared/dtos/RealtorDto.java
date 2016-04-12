package kz.maks.realestate.shared.dtos;

import kz.maks.core.shared.dtos.AbstractIdDto;

import java.util.List;

public class RealtorDto extends AbstractIdDto {
    private String krishaId;
    private String name;
    private String company;
    private String vidDeyatelnosti;
    private List<String> telNumbers;

    public String getKrishaId() {
        return krishaId;
    }

    public void setKrishaId(String krishaId) {
        this.krishaId = krishaId;
    }

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
