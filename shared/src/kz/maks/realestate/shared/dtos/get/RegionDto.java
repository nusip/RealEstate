package kz.maks.realestate.shared.dtos.get;

import kz.maks.core.shared.dtos.AbstractIdDto;

import java.util.ArrayList;
import java.util.List;

public class RegionDto extends AbstractIdDto {
    private String name;
    private RegionDto parent;
    private List<RegionDto> children = new ArrayList<>();
    private String krishaId;
    private String krishaAlias;
    private String path;
    private Boolean deleted;
    private Long updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionDto getParent() {
        return parent;
    }

    public void setParent(RegionDto parent) {
        this.parent = parent;
    }

    public List<RegionDto> getChildren() {
        return children;
    }

    public void setChildren(List<RegionDto> children) {
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

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
