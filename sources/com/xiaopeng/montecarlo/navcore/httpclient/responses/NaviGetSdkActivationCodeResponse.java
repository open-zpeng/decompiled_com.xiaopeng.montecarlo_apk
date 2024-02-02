package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviGetSdkActivationCodeResponse {
    @SerializedName("activeCode")
    private String mActiveCode;
    @SerializedName("seqNo")
    private String mSeqNo;
    @SerializedName("uuid")
    private String mUuid;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviGetSdkActivationCodeResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviGetSdkActivationCodeResponse) {
            NaviGetSdkActivationCodeResponse naviGetSdkActivationCodeResponse = (NaviGetSdkActivationCodeResponse) obj;
            if (naviGetSdkActivationCodeResponse.canEqual(this)) {
                String uuid = getUuid();
                String uuid2 = naviGetSdkActivationCodeResponse.getUuid();
                if (uuid != null ? uuid.equals(uuid2) : uuid2 == null) {
                    String seqNo = getSeqNo();
                    String seqNo2 = naviGetSdkActivationCodeResponse.getSeqNo();
                    if (seqNo != null ? seqNo.equals(seqNo2) : seqNo2 == null) {
                        String activeCode = getActiveCode();
                        String activeCode2 = naviGetSdkActivationCodeResponse.getActiveCode();
                        return activeCode != null ? activeCode.equals(activeCode2) : activeCode2 == null;
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
        String uuid = getUuid();
        int hashCode = uuid == null ? 43 : uuid.hashCode();
        String seqNo = getSeqNo();
        int hashCode2 = ((hashCode + 59) * 59) + (seqNo == null ? 43 : seqNo.hashCode());
        String activeCode = getActiveCode();
        return (hashCode2 * 59) + (activeCode != null ? activeCode.hashCode() : 43);
    }

    public NaviGetSdkActivationCodeResponse setActiveCode(String str) {
        this.mActiveCode = str;
        return this;
    }

    public NaviGetSdkActivationCodeResponse setSeqNo(String str) {
        this.mSeqNo = str;
        return this;
    }

    public NaviGetSdkActivationCodeResponse setUuid(String str) {
        this.mUuid = str;
        return this;
    }

    public String toString() {
        return "NaviGetSdkActivationCodeResponse(mUuid=" + getUuid() + ", mSeqNo=" + getSeqNo() + ", mActiveCode=" + getActiveCode() + ")";
    }

    public String getUuid() {
        return this.mUuid;
    }

    public String getSeqNo() {
        return this.mSeqNo;
    }

    public String getActiveCode() {
        return this.mActiveCode;
    }
}
