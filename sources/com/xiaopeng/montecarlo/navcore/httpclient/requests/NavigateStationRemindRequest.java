package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes2.dex */
public class NavigateStationRemindRequest {
    @SerializedName("operType")
    private String mOperType;
    @SerializedName("remainTime")
    private String mRemainTime;
    @SerializedName(CPSearchParam.PARAM_KEY_STATIONID)
    private String mStationId;
    @SerializedName("vin")
    private String mVin;

    protected boolean canEqual(Object obj) {
        return obj instanceof NavigateStationRemindRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NavigateStationRemindRequest) {
            NavigateStationRemindRequest navigateStationRemindRequest = (NavigateStationRemindRequest) obj;
            if (navigateStationRemindRequest.canEqual(this)) {
                String stationId = getStationId();
                String stationId2 = navigateStationRemindRequest.getStationId();
                if (stationId != null ? stationId.equals(stationId2) : stationId2 == null) {
                    String vin = getVin();
                    String vin2 = navigateStationRemindRequest.getVin();
                    if (vin != null ? vin.equals(vin2) : vin2 == null) {
                        String remainTime = getRemainTime();
                        String remainTime2 = navigateStationRemindRequest.getRemainTime();
                        if (remainTime != null ? remainTime.equals(remainTime2) : remainTime2 == null) {
                            String operType = getOperType();
                            String operType2 = navigateStationRemindRequest.getOperType();
                            return operType != null ? operType.equals(operType2) : operType2 == null;
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
        String stationId = getStationId();
        int hashCode = stationId == null ? 43 : stationId.hashCode();
        String vin = getVin();
        int hashCode2 = ((hashCode + 59) * 59) + (vin == null ? 43 : vin.hashCode());
        String remainTime = getRemainTime();
        int hashCode3 = (hashCode2 * 59) + (remainTime == null ? 43 : remainTime.hashCode());
        String operType = getOperType();
        return (hashCode3 * 59) + (operType != null ? operType.hashCode() : 43);
    }

    public NavigateStationRemindRequest setOperType(String str) {
        this.mOperType = str;
        return this;
    }

    public NavigateStationRemindRequest setRemainTime(String str) {
        this.mRemainTime = str;
        return this;
    }

    public NavigateStationRemindRequest setStationId(String str) {
        this.mStationId = str;
        return this;
    }

    public NavigateStationRemindRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "NavigateStationRemindRequest(mStationId=" + getStationId() + ", mVin=" + getVin() + ", mRemainTime=" + getRemainTime() + ", mOperType=" + getOperType() + ")";
    }

    public String getStationId() {
        return this.mStationId;
    }

    public String getVin() {
        return this.mVin;
    }

    public String getRemainTime() {
        return this.mRemainTime;
    }

    public String getOperType() {
        return this.mOperType;
    }
}
