package kz.maks.realestate.shared.dtos.params;

import kz.maks.core.shared.dtos.AbstractSearchParams;
import kz.maks.realestate.shared.models.YesNo;

public class UserSearchParams extends AbstractSearchParams {
    private String identifier;
    private String firstName;
    private YesNo isActive;

    public UserSearchParams() {
        this(null, null, YesNo.YES);
    }

    public UserSearchParams(String identifier, String firstName, YesNo isActive) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.isActive = isActive;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public YesNo getIsActive() {
        return isActive;
    }

    public void setIsActive(YesNo isActive) {
        this.isActive = isActive;
    }
}
