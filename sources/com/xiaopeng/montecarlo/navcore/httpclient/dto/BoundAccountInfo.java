package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class BoundAccountInfo {
    public static final int THIRD_TYPE_AUTONAVI = 7;
    @SerializedName("state")
    private Integer mState;
    @SerializedName("thirdId")
    private String mThirdId;
    @SerializedName("thirdType")
    private Integer mThirdType;

    protected boolean canEqual(Object obj) {
        return obj instanceof BoundAccountInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BoundAccountInfo) {
            BoundAccountInfo boundAccountInfo = (BoundAccountInfo) obj;
            if (boundAccountInfo.canEqual(this)) {
                Integer thirdType = getThirdType();
                Integer thirdType2 = boundAccountInfo.getThirdType();
                if (thirdType != null ? thirdType.equals(thirdType2) : thirdType2 == null) {
                    Integer state = getState();
                    Integer state2 = boundAccountInfo.getState();
                    if (state != null ? state.equals(state2) : state2 == null) {
                        String thirdId = getThirdId();
                        String thirdId2 = boundAccountInfo.getThirdId();
                        return thirdId != null ? thirdId.equals(thirdId2) : thirdId2 == null;
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
        Integer thirdType = getThirdType();
        int hashCode = thirdType == null ? 43 : thirdType.hashCode();
        Integer state = getState();
        int hashCode2 = ((hashCode + 59) * 59) + (state == null ? 43 : state.hashCode());
        String thirdId = getThirdId();
        return (hashCode2 * 59) + (thirdId != null ? thirdId.hashCode() : 43);
    }

    public BoundAccountInfo setState(Integer num) {
        this.mState = num;
        return this;
    }

    public BoundAccountInfo setThirdId(String str) {
        this.mThirdId = str;
        return this;
    }

    public BoundAccountInfo setThirdType(Integer num) {
        this.mThirdType = num;
        return this;
    }

    public String toString() {
        return "BoundAccountInfo(mThirdType=" + getThirdType() + ", mThirdId=" + getThirdId() + ", mState=" + getState() + ")";
    }

    public Integer getThirdType() {
        return this.mThirdType;
    }

    public String getThirdId() {
        return this.mThirdId;
    }

    public Integer getState() {
        return this.mState;
    }
}
