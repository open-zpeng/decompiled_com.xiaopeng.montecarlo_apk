package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class AssistantPowerKResponse {
    @SerializedName("k")
    private Double mK;

    protected boolean canEqual(Object obj) {
        return obj instanceof AssistantPowerKResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssistantPowerKResponse) {
            AssistantPowerKResponse assistantPowerKResponse = (AssistantPowerKResponse) obj;
            if (assistantPowerKResponse.canEqual(this)) {
                Double k = getK();
                Double k2 = assistantPowerKResponse.getK();
                return k != null ? k.equals(k2) : k2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Double k = getK();
        return 59 + (k == null ? 43 : k.hashCode());
    }

    public AssistantPowerKResponse setK(Double d) {
        this.mK = d;
        return this;
    }

    public String toString() {
        return "AssistantPowerKResponse(mK=" + getK() + ")";
    }

    public Double getK() {
        return this.mK;
    }
}
