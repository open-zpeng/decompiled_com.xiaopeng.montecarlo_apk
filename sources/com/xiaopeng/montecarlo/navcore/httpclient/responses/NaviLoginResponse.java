package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviLoginResponse {
    @SerializedName("openId")
    private String mOpenId;
    @SerializedName("sid")
    private String mSid;
    @SerializedName("unionId")
    private String mUnionId;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviLoginResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviLoginResponse) {
            NaviLoginResponse naviLoginResponse = (NaviLoginResponse) obj;
            if (naviLoginResponse.canEqual(this)) {
                String sid = getSid();
                String sid2 = naviLoginResponse.getSid();
                if (sid != null ? sid.equals(sid2) : sid2 == null) {
                    String openId = getOpenId();
                    String openId2 = naviLoginResponse.getOpenId();
                    if (openId != null ? openId.equals(openId2) : openId2 == null) {
                        String unionId = getUnionId();
                        String unionId2 = naviLoginResponse.getUnionId();
                        return unionId != null ? unionId.equals(unionId2) : unionId2 == null;
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
        String sid = getSid();
        int hashCode = sid == null ? 43 : sid.hashCode();
        String openId = getOpenId();
        int hashCode2 = ((hashCode + 59) * 59) + (openId == null ? 43 : openId.hashCode());
        String unionId = getUnionId();
        return (hashCode2 * 59) + (unionId != null ? unionId.hashCode() : 43);
    }

    public NaviLoginResponse setOpenId(String str) {
        this.mOpenId = str;
        return this;
    }

    public NaviLoginResponse setSid(String str) {
        this.mSid = str;
        return this;
    }

    public NaviLoginResponse setUnionId(String str) {
        this.mUnionId = str;
        return this;
    }

    public String toString() {
        return "NaviLoginResponse(mSid=" + getSid() + ", mOpenId=" + getOpenId() + ", mUnionId=" + getUnionId() + ")";
    }

    public String getSid() {
        return this.mSid;
    }

    public String getOpenId() {
        return this.mOpenId;
    }

    public String getUnionId() {
        return this.mUnionId;
    }
}
