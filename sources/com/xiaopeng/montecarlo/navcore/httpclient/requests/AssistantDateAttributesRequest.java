package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class AssistantDateAttributesRequest {
    @SerializedName("date")
    private String mDate;
    @SerializedName("ts")
    private Long mTs;
    @SerializedName("vin")
    private String mVin;

    protected boolean canEqual(Object obj) {
        return obj instanceof AssistantDateAttributesRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssistantDateAttributesRequest) {
            AssistantDateAttributesRequest assistantDateAttributesRequest = (AssistantDateAttributesRequest) obj;
            if (assistantDateAttributesRequest.canEqual(this)) {
                Long ts = getTs();
                Long ts2 = assistantDateAttributesRequest.getTs();
                if (ts != null ? ts.equals(ts2) : ts2 == null) {
                    String vin = getVin();
                    String vin2 = assistantDateAttributesRequest.getVin();
                    if (vin != null ? vin.equals(vin2) : vin2 == null) {
                        String date = getDate();
                        String date2 = assistantDateAttributesRequest.getDate();
                        return date != null ? date.equals(date2) : date2 == null;
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
        Long ts = getTs();
        int hashCode = ts == null ? 43 : ts.hashCode();
        String vin = getVin();
        int hashCode2 = ((hashCode + 59) * 59) + (vin == null ? 43 : vin.hashCode());
        String date = getDate();
        return (hashCode2 * 59) + (date != null ? date.hashCode() : 43);
    }

    public AssistantDateAttributesRequest setDate(String str) {
        this.mDate = str;
        return this;
    }

    public AssistantDateAttributesRequest setTs(Long l) {
        this.mTs = l;
        return this;
    }

    public AssistantDateAttributesRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "AssistantDateAttributesRequest(mVin=" + getVin() + ", mDate=" + getDate() + ", mTs=" + getTs() + ")";
    }

    public String getVin() {
        return this.mVin;
    }

    public String getDate() {
        return this.mDate;
    }

    public Long getTs() {
        return this.mTs;
    }
}
