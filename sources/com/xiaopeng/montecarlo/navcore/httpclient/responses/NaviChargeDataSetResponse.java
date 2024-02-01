package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class NaviChargeDataSetResponse {
    @SerializedName("dataset_url")
    private String mDataSetUrl;
    @SerializedName("update")
    private boolean mUpdate;
    @SerializedName("version")
    private long mVersionId;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviChargeDataSetResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviChargeDataSetResponse) {
            NaviChargeDataSetResponse naviChargeDataSetResponse = (NaviChargeDataSetResponse) obj;
            if (naviChargeDataSetResponse.canEqual(this) && getVersionId() == naviChargeDataSetResponse.getVersionId() && isUpdate() == naviChargeDataSetResponse.isUpdate()) {
                String dataSetUrl = getDataSetUrl();
                String dataSetUrl2 = naviChargeDataSetResponse.getDataSetUrl();
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

    public NaviChargeDataSetResponse setDataSetUrl(String str) {
        this.mDataSetUrl = str;
        return this;
    }

    public NaviChargeDataSetResponse setUpdate(boolean z) {
        this.mUpdate = z;
        return this;
    }

    public NaviChargeDataSetResponse setVersionId(long j) {
        this.mVersionId = j;
        return this;
    }

    public String toString() {
        return "NaviChargeDataSetResponse(mVersionId=" + getVersionId() + ", mDataSetUrl=" + getDataSetUrl() + ", mUpdate=" + isUpdate() + ")";
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
