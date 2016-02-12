package kz.maks.realestate.parser.models;

import com.google.gson.annotations.Expose;

import java.util.List;

public class KrishaRegion {
    @Expose
    private String id;
    @Expose
    private String label;
    @Expose
    private String alias;

    private List<KrishaRegion> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<KrishaRegion> getChildren() {
        return children;
    }

    public void setChildren(List<KrishaRegion> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "KrishaRegion{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
