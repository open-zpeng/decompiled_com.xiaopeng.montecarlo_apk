package com.xiaopeng.montecarlo.navcore.download.dataoperator;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class MapDataContent {
    @SerializedName("ad_code")
    private int mAdCode;
    @SerializedName("device_id")
    private String mDeviceId;
    @SerializedName("operate")
    private int mOperate = 0;

    protected boolean canEqual(Object obj) {
        return obj instanceof MapDataContent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MapDataContent) {
            MapDataContent mapDataContent = (MapDataContent) obj;
            if (mapDataContent.canEqual(this) && getAdCode() == mapDataContent.getAdCode() && getOperate() == mapDataContent.getOperate()) {
                String deviceId = getDeviceId();
                String deviceId2 = mapDataContent.getDeviceId();
                return deviceId != null ? deviceId.equals(deviceId2) : deviceId2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int adCode = ((getAdCode() + 59) * 59) + getOperate();
        String deviceId = getDeviceId();
        return (adCode * 59) + (deviceId == null ? 43 : deviceId.hashCode());
    }

    public void setAdCode(int i) {
        this.mAdCode = i;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setOperate(int i) {
        this.mOperate = i;
    }

    public String toString() {
        return "MapDataContent(mDeviceId=" + getDeviceId() + ", mAdCode=" + getAdCode() + ", mOperate=" + getOperate() + ")";
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public int getAdCode() {
        return this.mAdCode;
    }

    public int getOperate() {
        return this.mOperate;
    }
}
