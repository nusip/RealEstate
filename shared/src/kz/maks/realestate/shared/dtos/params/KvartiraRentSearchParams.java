package kz.maks.realestate.shared.dtos.params;

import kz.maks.core.shared.dtos.AbstractSearchParams;
import kz.maks.realestate.shared.models.RoomRange;

public class KvartiraRentSearchParams extends AbstractSearchParams {
    private RoomRange rooms;
    private Long regionId;

    /**
     * default search params
     */
    public KvartiraRentSearchParams() {
        this(RoomRange.ANY, null);
    }

    public KvartiraRentSearchParams(RoomRange rooms, Long regionId) {
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
