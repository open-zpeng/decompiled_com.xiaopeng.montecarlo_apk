package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class AssistantPowerDumpEnergyRequest {
    @SerializedName("ts")
    private Long mTs;
    @SerializedName("userId")
    private Long mUserId;
    @SerializedName("vin")
    private String mVin;

    protected boolean canEqual(Object obj) {
        return obj instanceof AssistantPowerDumpEnergyRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssistantPowerDumpEnergyRequest) {
            AssistantPowerDumpEnergyRequest assistantPowerDumpEnergyRequest = (AssistantPowerDumpEnergyRequest) obj;
            if (assistantPowerDumpEnergyRequest.canEqual(this)) {
                Long userId = getUserId();
                Long userId2 = assistantPowerDumpEnergyRequest.getUserId();
                if (userId != null ? userId.equals(userId2) : userId2 == null) {
                    Long ts = getTs();
                    Long ts2 = assistantPowerDumpEnergyRequest.getTs();
                    if (ts != null ? ts.equals(ts2) : ts2 == null) {
                        String vin = getVin();
                        String vin2 = assistantPowerDumpEnergyRequest.getVin();
                        return vin != null ? vin.equals(vin2) : vin2 == null;
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
        Long userId = getUserId();
        int hashCode = userId == null ? 43 : userId.hashCode();
        Long ts = getTs();
        int hashCode2 = ((hashCode + 59) * 59) + (ts == null ? 43 : ts.hashCode());
        String vin = getVin();
        return (hashCode2 * 59) + (vin != null ? vin.hashCode() : 43);
    }

    public AssistantPowerDumpEnergyRequest setTs(Long l) {
        this.mTs = l;
        return this;
    }

    public AssistantPowerDumpEnergyRequest setUserId(Long l) {
        this.mUserId = l;
        return this;
    }

    public AssistantPowerDumpEnergyRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "AssistantPowerDumpEnergyRequest(mVin=" + getVin() + ", mUserId=" + getUserId() + ", mTs=" + getTs() + ")";
    }

    public String getVin() {
        return this.mVin;
    }

    public Long getUserId() {
        return this.mUserId;
    }

    public Long getTs() {
        return this.mTs;
    }
}
