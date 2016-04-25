package kz.maks.realestate.shared.dtos.params;

import kz.maks.core.shared.dtos.AbstractSearchParams;
import kz.maks.realestate.shared.models.RoomRange;
import kz.maks.realestate.shared.models.SortField;
import kz.maks.realestate.shared.models.YesNo;

import java.util.Date;

public class KvartiraRentSearchParams extends AbstractSearchParams {
    private Date dataSozdaniyaFrom;
    private Date dataSozdaniyaTo;
    private Long regionId;
    private RoomRange rooms;
    private Integer etazhMin;
    private Integer etazhMax;
    private Integer etazhnostMin;
    private Integer etazhnostMax;
    private Double ploshadObshayaMin;
    private Double ploshadObshayaMax;
    private Double ploshadKuhnyaMin;
    private Double ploshadKuhnyaMax;
    private YesNo obwyaga;
    private YesNo vArhive;

    /**
     * default search params
     */
    public KvartiraRentSearchParams() {
        this(new Date(), new Date(), null, RoomRange.ANY,
                0, 0,
                0, 0,
                0.0, 0.0,
                0.0, 0.0,
                YesNo.NO_MATTER,
                YesNo.NO,
                SortField.createdAt.name()
        );
    }

    public KvartiraRentSearchParams(Date dataSozdaniyaFrom, Date dataSozdaniyaTo, Long regionId, RoomRange rooms,
                                    Integer etazhMin, Integer etazhMax, Integer etazhnostMin, Integer etazhnostMax,
                                    Double ploshadObshayaMin, Double ploshadObshayaMax,
                                    Double ploshadKuhnyaMin, Double ploshadKuhnyaMax, YesNo obwyaga, YesNo vArhive,
                                    String sortField) {
        this.dataSozdaniyaFrom = dataSozdaniyaFrom;
        this.dataSozdaniyaTo = dataSozdaniyaTo;
        this.regionId = regionId;
        this.rooms = rooms;
        this.etazhMin = etazhMin;
        this.etazhMax = etazhMax;
        this.etazhnostMin = etazhnostMin;
        this.etazhnostMax = etazhnostMax;
        this.ploshadObshayaMin = ploshadObshayaMin;
        this.ploshadObshayaMax = ploshadObshayaMax;
        this.ploshadKuhnyaMin = ploshadKuhnyaMin;
        this.ploshadKuhnyaMax = ploshadKuhnyaMax;
        this.obwyaga = obwyaga;
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

    public Integer getEtazhMin() {
        return etazhMin;
    }

    public void setEtazhMin(Integer etazhMin) {
        this.etazhMin = etazhMin;
    }

    public Integer getEtazhMax() {
        return etazhMax;
    }

    public void setEtazhMax(Integer etazhMax) {
        this.etazhMax = etazhMax;
    }

    public Integer getEtazhnostMin() {
        return etazhnostMin;
    }

    public void setEtazhnostMin(Integer etazhnostMin) {
        this.etazhnostMin = etazhnostMin;
    }

    public Integer getEtazhnostMax() {
        return etazhnostMax;
    }

    public void setEtazhnostMax(Integer etazhnostMax) {
        this.etazhnostMax = etazhnostMax;
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

    public YesNo getObwyaga() {
        return obwyaga;
    }

    public void setObwyaga(YesNo obwyaga) {
        this.obwyaga = obwyaga;
    }

    public YesNo getVArhive() {
        return vArhive;
    }

    public void setVArhive(YesNo vArhive) {
        this.vArhive = vArhive;
    }
}
