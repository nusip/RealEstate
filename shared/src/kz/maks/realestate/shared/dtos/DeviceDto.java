package kz.maks.realestate.shared.dtos;

import kz.maks.core.shared.dtos.AbstractIdDto;

public class DeviceDto extends AbstractIdDto {
    private Long clientId;
    private String clientName;
    private String number;
    private boolean isActive;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
