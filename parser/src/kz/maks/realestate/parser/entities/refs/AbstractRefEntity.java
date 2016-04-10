package kz.maks.realestate.parser.entities.refs;

import kz.maks.core.back.entities.AbstractBaseEntity;
import kz.maks.core.shared.models.ICombo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractRefEntity extends AbstractBaseEntity implements ICombo {
    @Column(unique = true)
    private String code;
    private String title;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
