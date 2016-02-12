package kz.maks.realestate.parser.entities;

import kz.maks.core.shared.models.ITreeNode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Region")
public class Region extends AbstractKrishaEntity implements ITreeNode<Region> {
    private String name;

    @ManyToOne
    private Region parent;

    @OneToMany(mappedBy = "parent")
    private List<Region> children = new ArrayList<>();

    private String krishaAlias;

    private String path;

    private Boolean deleted;

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Region getParent() {
        return parent;
    }

    public void setParent(Region parent) {
        this.parent = parent;
    }

    @Override
    public List<Region> getChildren() {
        return children;
    }

    public void setChildren(List<Region> children) {
        this.children = children;
    }

    public String getKrishaId() {
        return krishaId;
    }

    public void setKrishaId(String krishaId) {
        this.krishaId = krishaId;
    }

    public String getKrishaAlias() {
        return krishaAlias;
    }

    public void setKrishaAlias(String krishaAlias) {
        this.krishaAlias = krishaAlias;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
