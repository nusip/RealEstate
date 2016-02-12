package kz.maks.realestate.shared.dtos.params;

import kz.maks.core.shared.dtos.AbstractSearchParams;
import kz.maks.realestate.shared.models.RoomRange;

public class KvartiraSaleSearchParams extends AbstractSearchParams {
    private RoomRange rooms;
    private Long regionId;

    /**
     * default search params
     */
    public KvartiraSaleSearchParams() {
        this(RoomRange.ANY, null);
    }

    public KvartiraSaleSearchParams(RoomRange rooms, Long regionId) {
        this.rooms = rooms;
        this.regionId = regionId;
    }

    public RoomRange getRooms() {
        return rooms;
    }

    public void setRooms(RoomRange rooms) {
        this.rooms = rooms;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
}