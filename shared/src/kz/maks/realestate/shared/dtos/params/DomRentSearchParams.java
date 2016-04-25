package kz.maks.realestate.shared.dtos.params;

import kz.maks.core.shared.dtos.AbstractSearchParams;
import kz.maks.realestate.shared.models.RoomRange;
import kz.maks.realestate.shared.models.SortField;
import kz.maks.realestate.shared.models.YesNo;

import java.util.Date;

public class DomRentSearchParams extends AbstractSearchParams {
    private Date dataSozdaniyaFrom;
    private Date dataSozdaniyaTo;
    private Long regionId;
    private RoomRange rooms;
    private Double ploshadObshayaMin;
    private Double ploshadObshayaMax;
    private Double ploshadKuhnyaMin;
    private Double ploshadKuhnyaMax;
    private YesNo vArhive;

    /**
     * default search params
     */
    public DomRentSearchParams() {
        this(new Date(), new Date(), null, RoomRange.ANY, 0.0, 0.0, 0.0, 0.0, YesNo.NO, SortField.createdAt.name());
    }

    public DomRentSearchParams(Date dataSozdaniyaFrom, Date dataSozdaniyaTo, Long regionId, RoomRange rooms,
                               Double ploshadObshayaMin, Double ploshadObshayaMax,
                               Double ploshadKuhnyaMin, Double ploshadKuhnyaMax, YesNo vArhive, String sortField) {
        this.dataSozdaniyaFrom = dataSozdaniyaFrom;
        this.dataSozdaniyaTo = dataSozdaniyaTo;
        this.regionId = regionId;
        this.rooms = rooms;
        this.ploshadObshayaMin = ploshadObshayaMin;
        this.ploshadObshayaMax = ploshadObshayaMax;
        this.ploshadKuhnyaMin = ploshadKuhnyaMin;
        this.ploshadKuhnyaMax = ploshadKuhnyaMax;
        this.vArhive = vArhive;
        this.sortField = sortField;
    }

    public Date getDataSozdaniyaFrom() {
        return dataSozdaniyaFrom;
    }

    public void setDataSozdaniyaFrom(Date dataSozdaniyaFrom) {
        this.dataSozdaniyaFrom = dataSozdaniyaFrom;
    }

    public Date getDataSozdaniyaTo() {
        return dataSozdaniyaTo;
    }

    public void setDataSozdaniyaTo(Date dataSozdaniyaTo) {
        this.dataSozdaniyaTo = dataSozdaniyaTo;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public RoomRange getRooms() {
        return rooms;
    }

    public void setRooms(RoomRange rooms) {
        this.rooms = rooms;
    }

    public Double getPloshadObshayaMin() {
        return ploshadObshayaMin;
    }

    public void setPloshadObshayaMin(Double ploshadObshayaMin) {
        this.ploshadObshayaMin = ploshadObshayaMin;
    }

    public Double getPloshadObshayaMax() {
        return ploshadObshayaMax;
    }

    public void setPloshadObshayaMax(Double ploshadObshayaMax) {
        this.ploshadObshayaMax = ploshadObshayaMax;
    }

    public Double getPloshadKuhnyaMin() {
        return ploshadKuhnyaMin;
    }

    public void setPloshadKuhnyaMin(Double ploshadKuhnyaMin) {
        this.ploshadKuhnyaMin = ploshadKuhnyaMin;
    }

    public Double getPloshadKuhnyaMax() {
        return ploshadKuhnyaMax;
    }

    public void setPloshadKuhnyaMax(Double ploshadKuhnyaMax) {
        this.ploshadKuhnyaMax = ploshadKuhnyaMax;
    }

    public YesNo getVArhive() {
        return vArhive;
    }

    public void setVArhive(YesNo vArhive) {
        this.vArhive = vArhive;
    }
}
