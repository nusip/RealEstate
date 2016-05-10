package kz.maks.realestate.shared.dtos;

import kz.maks.core.shared.dtos.AbstractIdDto;

import java.util.List;

public class ClientDto extends AbstractIdDto {
    private String name;
    private boolean isActive;
    private List<String> deviceNumbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<String> getDeviceNumbers() {
        return deviceNumbers;
    }

    public void setDeviceNumbers(List<String> deviceNumbers) {
        this.deviceNumbers = deviceNumbers;
    }
}
