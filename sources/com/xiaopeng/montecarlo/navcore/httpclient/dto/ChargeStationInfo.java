package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes2.dex */
public class ChargeStationInfo {
    @SerializedName("address")
    String mAddress;
    @SerializedName(CPSearchParam.PARAM_KEY_LAT)
    String mLat;
    @SerializedName("lineDistance")
    @Expose(serialize = false)
    int mLineDistance;
    @SerializedName(CPSearchParam.PARAM_KEY_LNG)
    String mLng;
    @SerializedName("name")
    String mName;
    @SerializedName("navDistance")
    @Expose(serialize = false)
    int mNavDistance;
    @SerializedName("onRemainDis")
    @Expose(serialize = false)
    int mOnRemainDis;
    @SerializedName("source")
    int mSource;
    @SerializedName(CPSearchParam.PARAM_KEY_STATIONID)
    String mStationId;
    @SerializedName("type")
    int mType;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeStationInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeStationInfo) {
            ChargeStationInfo chargeStationInfo = (ChargeStationInfo) obj;
            if (chargeStationInfo.canEqual(this) && getSource() == chargeStationInfo.getSource() && getType() == chargeStationInfo.getType() && getLineDistance() == chargeStationInfo.getLineDistance() && getNavDistance() == chargeStationInfo.getNavDistance() && getOnRemainDis() == chargeStationInfo.getOnRemainDis()) {
                String stationId = getStationId();
                String stationId2 = chargeStationInfo.getStationId();
                if (stationId != null ? stationId.equals(stationId2) : stationId2 == null) {
                    String name = getName();
                    String name2 = chargeStationInfo.getName();
                    if (name != null ? name.equals(name2) : name2 == null) {
                        String address = getAddress();
                        String address2 = chargeStationInfo.getAddress();
                        if (address != null ? address.equals(address2) : address2 == null) {
                            String lng = getLng();
                            String lng2 = chargeStationInfo.getLng();
                            if (lng != null ? lng.equals(lng2) : lng2 == null) {
                                String lat = getLat();
                                String lat2 = chargeStationInfo.getLat();
                                return lat != null ? lat.equals(lat2) : lat2 == null;
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
        return false;
    }

    public int hashCode() {
        int source = ((((((((getSource() + 59) * 59) + getType()) * 59) + getLineDistance()) * 59) + getNavDistance()) * 59) + getOnRemainDis();
        String stationId = getStationId();
        int hashCode = (source * 59) + (stationId == null ? 43 : stationId.hashCode());
        String name = getName();
        int hashCode2 = (hashCode * 59) + (name == null ? 43 : name.hashCode());
        String address = getAddress();
        int hashCode3 = (hashCode2 * 59) + (address == null ? 43 : address.hashCode());
        String lng = getLng();
        int hashCode4 = (hashCode3 * 59) + (lng == null ? 43 : lng.hashCode());
        String lat = getLat();
        return (hashCode4 * 59) + (lat != null ? lat.hashCode() : 43);
    }

    public ChargeStationInfo setAddress(String str) {
        this.mAddress = str;
        return this;
    }

    public ChargeStationInfo setLat(String str) {
        this.mLat = str;
        return this;
    }

    public ChargeStationInfo setLineDistance(int i) {
        this.mLineDistance = i;
        return this;
    }

    public ChargeStationInfo setLng(String str) {
        this.mLng = str;
        return this;
    }

    public ChargeStationInfo setName(String str) {
        this.mName = str;
        return this;
    }

    public ChargeStationInfo setNavDistance(int i) {
        this.mNavDistance = i;
        return this;
    }

    public ChargeStationInfo setOnRemainDis(int i) {
        this.mOnRemainDis = i;
        return this;
    }

    public ChargeStationInfo setSource(int i) {
        this.mSource = i;
        return this;
    }

    public ChargeStationInfo setStationId(String str) {
        this.mStationId = str;
        return this;
    }

    public ChargeStationInfo setType(int i) {
        this.mType = i;
        return this;
    }

    public String toString() {
        return "ChargeStationInfo(mStationId=" + getStationId() + ", mSource=" + getSource() + ", mName=" + getName() + ", mAddress=" + getAddress() + ", mLng=" + getLng() + ", mLat=" + getLat() + ", mType=" + getType() + ", mLineDistance=" + getLineDistance() + ", mNavDistance=" + getNavDistance() + ", mOnRemainDis=" + getOnRemainDis() + ")";
    }

    public String getStationId() {
        return this.mStationId;
    }

    public int getSource() {
        return this.mSource;
    }

    public String getName() {
        return this.mName;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getLng() {
        return this.mLng;
    }

    public String getLat() {
        return this.mLat;
    }

    public int getType() {
        return this.mType;
    }

    public int getLineDistance() {
        return this.mLineDistance;
    }

    public int getNavDistance() {
        return this.mNavDistance;
    }

    public int getOnRemainDis() {
        return this.mOnRemainDis;
    }
}
