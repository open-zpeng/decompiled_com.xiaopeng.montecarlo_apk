package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviChargeDataSetRequest {
    @SerializedName("ts")
    private Long mTs;
    @SerializedName("version")
    private Long mVersionId;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviChargeDataSetRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviChargeDataSetRequest) {
            NaviChargeDataSetRequest naviChargeDataSetRequest = (NaviChargeDataSetRequest) obj;
            if (naviChargeDataSetRequest.canEqual(this)) {
                Long versionId = getVersionId();
                Long versionId2 = naviChargeDataSetRequest.getVersionId();
                if (versionId != null ? versionId.equals(versionId2) : versionId2 == null) {
                    Long ts = getTs();
                    Long ts2 = naviChargeDataSetRequest.getTs();
                    return ts != null ? ts.equals(ts2) : ts2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Long versionId = getVersionId();
        int hashCode = versionId == null ? 43 : versionId.hashCode();
        Long ts = getTs();
        return ((hashCode + 59) * 59) + (ts != null ? ts.hashCode() : 43);
    }

    public NaviChargeDataSetRequest setTs(Long l) {
        this.mTs = l;
        return this;
    }

    public NaviChargeDataSetRequest setVersionId(Long l) {
        this.mVersionId = l;
        return this;
    }

    public String toString() {
        return "NaviChargeDataSetRequest(mVersionId=" + getVersionId() + ", mTs=" + getTs() + ")";
    }

    public Long getVersionId() {
        return this.mVersionId;
    }

    public Long getTs() {
        return this.mTs;
    }
}
