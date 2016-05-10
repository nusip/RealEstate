package kz.maks.realestate.shared.dtos.params;

import kz.maks.core.shared.dtos.AbstractSearchParams;
import kz.maks.realestate.shared.models.YesNo;

public class DeviceSearchParams extends AbstractSearchParams {
    private String clientName;
    private String number;
    private YesNo isActive;

    public DeviceSearchParams() {
        this(null, null, YesNo.YES);
    }

    public DeviceSearchParams(String clientName, String number, YesNo isActive) {
        this.clientName = clientName;
        this.number = number;
        this.isActive = isActive;
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

    public YesNo getIsActive() {
        return isActive;
    }

    public void setIsActive(YesNo isActive) {
        this.isActive = isActive;
    }
}
