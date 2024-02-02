package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
/* loaded from: classes2.dex */
public class ChargeDataSetResponse {
    @SerializedName("dataSetUrl")
    private String mDataSetUrl;
    @SerializedName("update")
    private boolean mUpdate;
    @SerializedName(CPSearchParam.PARAM_KEY_VERSIONID)
    private long mVersionId;

    protected boolean canEqual(Object obj) {
        return obj instanceof ChargeDataSetResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChargeDataSetResponse) {
            ChargeDataSetResponse chargeDataSetResponse = (ChargeDataSetResponse) obj;
            if (chargeDataSetResponse.canEqual(this) && getVersionId() == chargeDataSetResponse.getVersionId() && isUpdate() == chargeDataSetResponse.isUpdate()) {
                String dataSetUrl = getDataSetUrl();
                String dataSetUrl2 = chargeDataSetResponse.getDataSetUrl();
                return dataSetUrl != null ? dataSetUrl.equals(dataSetUrl2) : dataSetUrl2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long versionId = getVersionId();
        int i = ((((int) (versionId ^ (versionId >>> 32))) + 59) * 59) + (isUpdate() ? 79 : 97);
        String dataSetUrl = getDataSetUrl();
        return (i * 59) + (dataSetUrl == null ? 43 : dataSetUrl.hashCode());
    }

    public ChargeDataSetResponse setDataSetUrl(String str) {
        this.mDataSetUrl = str;
        return this;
    }

    public ChargeDataSetResponse setUpdate(boolean z) {
        this.mUpdate = z;
        return this;
    }

    public ChargeDataSetResponse setVersionId(long j) {
        this.mVersionId = j;
        return this;
    }

    public String toString() {
        return "ChargeDataSetResponse(mVersionId=" + getVersionId() + ", mDataSetUrl=" + getDataSetUrl() + ", mUpdate=" + isUpdate() + ")";
    }

    public long getVersionId() {
        return this.mVersionId;
    }

    public String getDataSetUrl() {
        return this.mDataSetUrl;
    }

    public boolean isUpdate() {
        return this.mUpdate;
    }
}
