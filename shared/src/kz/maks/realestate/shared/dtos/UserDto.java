package kz.maks.realestate.shared.dtos;

import kz.maks.core.shared.dtos.AbstractIdDto;

import java.util.List;

public class UserDto extends AbstractIdDto {
    private String identifier;
    private String credentials;
    private String firstName;
    private String lastName;
    private String middleName;
    private String fullName;
    private boolean isActive;
    private List<Long> roleIds;
    private List<String> roleTitles;
    private List<String> roleNames;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getRoleTitles() {
        return roleTitles;
    }

    public void setRoleTitles(List<String> roleTitles) {
        this.roleTitles = roleTitles;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
