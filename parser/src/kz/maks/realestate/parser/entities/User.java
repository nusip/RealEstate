package kz.maks.realestate.parser.entities;

import com.google.common.base.Joiner;
import kz.maks.core.back.entities.AbstractBaseEntity;
import kz.maks.core.back.entities.AbstractUserEntity;
import kz.maks.core.shared.models.ICombo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class User extends AbstractUserEntity implements ICombo {
    private String firstName;
    private String lastName;
    private String middleName;

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

    @Override
    @Transient
    public String title() {
        return Joiner.on(" ").skipNulls().join(getLastName(), getFirstName(), getMiddleName());
    }
}
