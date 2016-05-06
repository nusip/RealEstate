package kz.maks.realestate.parser.entities;

import com.google.common.base.Joiner;
import kz.maks.core.back.entities.AbstractBaseEntity;
import kz.maks.core.back.entities.AbstractUserEntity;
import kz.maks.core.shared.models.ICombo;

import javax.persistence.*;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "id_gen", sequenceName = "user_seq")
public class User extends AbstractUserEntity implements ICombo {
    public static final String FIRST_NAME_FIELD = "firstName";

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
    public String getTitle() {
        return getFullName();
    }

    @Transient
    public String getFullName() {
        return Joiner.on(" ").skipNulls().join(getLastName(), getFirstName(), getMiddleName());
    }
}
