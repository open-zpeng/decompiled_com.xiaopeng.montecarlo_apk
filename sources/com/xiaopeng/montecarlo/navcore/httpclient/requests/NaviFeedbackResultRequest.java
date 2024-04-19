package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.speech.protocol.bean.recommend.RecommendBean;
/* loaded from: classes2.dex */
public class NaviFeedbackResultRequest {
    @SerializedName(RecommendBean.SHOW_TIME_RESULT)
    private Boolean mResult;
    @SerializedName("uuid")
    private String mUuid;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviFeedbackResultRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviFeedbackResultRequest) {
            NaviFeedbackResultRequest naviFeedbackResultRequest = (NaviFeedbackResultRequest) obj;
            if (naviFeedbackResultRequest.canEqual(this)) {
                Boolean result = getResult();
                Boolean result2 = naviFeedbackResultRequest.getResult();
                if (result != null ? result.equals(result2) : result2 == null) {
                    String uuid = getUuid();
                    String uuid2 = naviFeedbackResultRequest.getUuid();
                    return uuid != null ? uuid.equals(uuid2) : uuid2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Boolean result = getResult();
        int hashCode = result == null ? 43 : result.hashCode();
        String uuid = getUuid();
        return ((hashCode + 59) * 59) + (uuid != null ? uuid.hashCode() : 43);
    }

    public NaviFeedbackResultRequest setResult(Boolean bool) {
        this.mResult = bool;
        return this;
    }

    public NaviFeedbackResultRequest setUuid(String str) {
        this.mUuid = str;
        return this;
    }

    public String toString() {
        return "NaviFeedbackResultRequest(mUuid=" + getUuid() + ", mResult=" + getResult() + ")";
    }

    public String getUuid() {
        return this.mUuid;
    }

    public Boolean getResult() {
        return this.mResult;
    }
}
