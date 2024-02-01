package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes3.dex */
public class ChargeDataSetRequest {
    @SerializedName("ts")
    private Long mTs;
    @SerializedName(CPSearchParam.PARAM_KEY_VERSIONID)
    private Long mVersionId;
    @SerializedName("vin")
    private String mVin;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeDataSetRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeDataSetRequest) {
            ChargeDataSetRequest chargeDataSetRequest = (ChargeDataSetRequest) obj;
            if (chargeDataSetRequest.canEqual(this)) {
                Long versionId = getVersionId();
                Long versionId2 = chargeDataSetRequest.getVersionId();
                if (versionId != null ? versionId.equals(versionId2) : versionId2 == null) {
                    Long ts = getTs();
                    Long ts2 = chargeDataSetRequest.getTs();
                    if (ts != null ? ts.equals(ts2) : ts2 == null) {
                        String vin = getVin();
                        String vin2 = chargeDataSetRequest.getVin();
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
        Long versionId = getVersionId();
        int hashCode = versionId == null ? 43 : versionId.hashCode();
        Long ts = getTs();
        int hashCode2 = ((hashCode + 59) * 59) + (ts == null ? 43 : ts.hashCode());
        String vin = getVin();
        return (hashCode2 * 59) + (vin != null ? vin.hashCode() : 43);
    }

    public ChargeDataSetRequest setTs(Long l) {
        this.mTs = l;
        return this;
    }

    public ChargeDataSetRequest setVersionId(Long l) {
        this.mVersionId = l;
        return this;
    }

    public ChargeDataSetRequest setVin(String str) {
        this.mVin = str;
        return this;
    }

    public String toString() {
        return "ChargeDataSetRequest(mVin=" + getVin() + ", mVersionId=" + getVersionId() + ", mTs=" + getTs() + ")";
    }

    public String getVin() {
        return this.mVin;
    }

    public Long getVersionId() {
        return this.mVersionId;
    }

    public Long getTs() {
        return this.mTs;
    }
}
