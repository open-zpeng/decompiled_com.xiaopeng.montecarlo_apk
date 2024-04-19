package com.xiaopeng.montecarlo.navcore.database.bean.greendao;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* loaded from: classes2.dex */
public class LccGeoFenceInfo {
    private static final L.Tag TAG = new L.Tag("LccGeoFenceInfo");
    @SerializedName(IntentActions.ActionsKey.KEY_ACTION)
    private int action;
    @SerializedName("cityCode")
    private String cityCode;
    @SerializedName("dangerLane")
    private int dangerLane;
    @SerializedName("dangerLaneNumber")
    private int dangerLaneNumber;
    @SerializedName("dangerLevel")
    private int dangerLevel;
    @SerializedName("dangerType")
    private int dangerType;
    private Long dbId;
    @SerializedName(VuiConstants.ELEMENT_ID)
    private String fenceId;
    @SerializedName("rangeLeftBottomLat")
    private double rangeLeftBottomLat;
    @SerializedName("rangeLeftBottomLon")
    private double rangeLeftBottomLon;
    @SerializedName("rangeRightTopLat")
    private double rangeRightTopLat;
    @SerializedName("rangeRightTopLon")
    private double rangeRightTopLon;
    @SerializedName("roadDir")
    public float roadDir;
    @SerializedName("roadName")
    private String roadName;
    @SerializedName("type1")
    private int type1;
    @SerializedName("type2")
    private int type2;

    protected boolean canEqual(Object obj) {
        return obj instanceof LccGeoFenceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LccGeoFenceInfo) {
            LccGeoFenceInfo lccGeoFenceInfo = (LccGeoFenceInfo) obj;
            if (lccGeoFenceInfo.canEqual(this) && Float.compare(getRoadDir(), lccGeoFenceInfo.getRoadDir()) == 0 && getType1() == lccGeoFenceInfo.getType1() && getType2() == lccGeoFenceInfo.getType2() && getAction() == lccGeoFenceInfo.getAction() && getDangerLaneNumber() == lccGeoFenceInfo.getDangerLaneNumber() && getDangerLane() == lccGeoFenceInfo.getDangerLane() && getDangerType() == lccGeoFenceInfo.getDangerType() && getDangerLevel() == lccGeoFenceInfo.getDangerLevel() && Double.compare(getRangeLeftBottomLon(), lccGeoFenceInfo.getRangeLeftBottomLon()) == 0 && Double.compare(getRangeLeftBottomLat(), lccGeoFenceInfo.getRangeLeftBottomLat()) == 0 && Double.compare(getRangeRightTopLon(), lccGeoFenceInfo.getRangeRightTopLon()) == 0 && Double.compare(getRangeRightTopLat(), lccGeoFenceInfo.getRangeRightTopLat()) == 0) {
                Long dbId = getDbId();
                Long dbId2 = lccGeoFenceInfo.getDbId();
                if (dbId != null ? dbId.equals(dbId2) : dbId2 == null) {
                    String fenceId = getFenceId();
                    String fenceId2 = lccGeoFenceInfo.getFenceId();
                    if (fenceId != null ? fenceId.equals(fenceId2) : fenceId2 == null) {
                        String roadName = getRoadName();
                        String roadName2 = lccGeoFenceInfo.getRoadName();
                        if (roadName != null ? roadName.equals(roadName2) : roadName2 == null) {
                            String cityCode = getCityCode();
                            String cityCode2 = lccGeoFenceInfo.getCityCode();
                            return cityCode != null ? cityCode.equals(cityCode2) : cityCode2 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int floatToIntBits = ((((((((((((((Float.floatToIntBits(getRoadDir()) + 59) * 59) + getType1()) * 59) + getType2()) * 59) + getAction()) * 59) + getDangerLaneNumber()) * 59) + getDangerLane()) * 59) + getDangerType()) * 59) + getDangerLevel();
        long doubleToLongBits = Double.doubleToLongBits(getRangeLeftBottomLon());
        int i = (floatToIntBits * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getRangeLeftBottomLat());
        int i2 = (i * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getRangeRightTopLon());
        int i3 = (i2 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(getRangeRightTopLat());
        int i4 = (i3 * 59) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        Long dbId = getDbId();
        int hashCode = (i4 * 59) + (dbId == null ? 43 : dbId.hashCode());
        String fenceId = getFenceId();
        int hashCode2 = (hashCode * 59) + (fenceId == null ? 43 : fenceId.hashCode());
        String roadName = getRoadName();
        int hashCode3 = (hashCode2 * 59) + (roadName == null ? 43 : roadName.hashCode());
        String cityCode = getCityCode();
        return (hashCode3 * 59) + (cityCode != null ? cityCode.hashCode() : 43);
    }

    public String toString() {
        return "LccGeoFenceInfo(dbId=" + getDbId() + ", fenceId=" + getFenceId() + ", roadName=" + getRoadName() + ", roadDir=" + getRoadDir() + ", cityCode=" + getCityCode() + ", type1=" + getType1() + ", type2=" + getType2() + ", action=" + getAction() + ", dangerLaneNumber=" + getDangerLaneNumber() + ", dangerLane=" + getDangerLane() + ", dangerType=" + getDangerType() + ", dangerLevel=" + getDangerLevel() + ", rangeLeftBottomLon=" + getRangeLeftBottomLon() + ", rangeLeftBottomLat=" + getRangeLeftBottomLat() + ", rangeRightTopLon=" + getRangeRightTopLon() + ", rangeRightTopLat=" + getRangeRightTopLat() + ")";
    }

    public LccGeoFenceInfo(Long l, String str, String str2, float f, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, double d, double d2, double d3, double d4) {
        this.dbId = l;
        this.fenceId = str;
        this.roadName = str2;
        this.roadDir = f;
        this.cityCode = str3;
        this.type1 = i;
        this.type2 = i2;
        this.action = i3;
        this.dangerLaneNumber = i4;
        this.dangerLane = i5;
        this.dangerType = i6;
        this.dangerLevel = i7;
        this.rangeLeftBottomLon = d;
        this.rangeLeftBottomLat = d2;
        this.rangeRightTopLon = d3;
        this.rangeRightTopLat = d4;
    }

    public LccGeoFenceInfo() {
    }

    public Long getDbId() {
        return this.dbId;
    }

    public void setDbId(Long l) {
        this.dbId = l;
    }

    public String getFenceId() {
        return this.fenceId;
    }

    public void setFenceId(String str) {
        this.fenceId = str;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public void setRoadName(String str) {
        this.roadName = str;
    }

    public float getRoadDir() {
        return this.roadDir;
    }

    public void setRoadDir(float f) {
        this.roadDir = f;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public int getType1() {
        return this.type1;
    }

    public void setType1(int i) {
        this.type1 = i;
    }

    public int getType2() {
        return this.type2;
    }

    public void setType2(int i) {
        this.type2 = i;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public int getDangerLaneNumber() {
        return this.dangerLaneNumber;
    }

    public void setDangerLaneNumber(int i) {
        this.dangerLaneNumber = i;
    }

    public int getDangerLane() {
        return this.dangerLane;
    }

    public void setDangerLane(int i) {
        this.dangerLane = i;
    }

    public int getDangerType() {
        return this.dangerType;
    }

    public void setDangerType(int i) {
        this.dangerType = i;
    }

    public int getDangerLevel() {
        return this.dangerLevel;
    }

    public void setDangerLevel(int i) {
        this.dangerLevel = i;
    }

    public double getRangeLeftBottomLon() {
        return this.rangeLeftBottomLon;
    }

    public void setRangeLeftBottomLon(double d) {
        this.rangeLeftBottomLon = d;
    }

    public double getRangeLeftBottomLat() {
        return this.rangeLeftBottomLat;
    }

    public void setRangeLeftBottomLat(double d) {
        this.rangeLeftBottomLat = d;
    }

    public double getRangeRightTopLon() {
        return this.rangeRightTopLon;
    }

    public void setRangeRightTopLon(double d) {
        this.rangeRightTopLon = d;
    }

    public double getRangeRightTopLat() {
        return this.rangeRightTopLat;
    }

    public void setRangeRightTopLat(double d) {
        this.rangeRightTopLat = d;
    }
}
