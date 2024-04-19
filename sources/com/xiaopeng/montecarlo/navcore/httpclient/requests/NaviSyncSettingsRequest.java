package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.DataOperation;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviSyncSettingsRequest {
    @SerializedName("dataList")
    private List<DataOperation> mDataList;
    @SerializedName("ignoreError")
    private Boolean mIgnoreError;
    @SerializedName("localVersion")
    private Long mLocalVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviSyncSettingsRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviSyncSettingsRequest) {
            NaviSyncSettingsRequest naviSyncSettingsRequest = (NaviSyncSettingsRequest) obj;
            if (naviSyncSettingsRequest.canEqual(this)) {
                Long localVersion = getLocalVersion();
                Long localVersion2 = naviSyncSettingsRequest.getLocalVersion();
                if (localVersion != null ? localVersion.equals(localVersion2) : localVersion2 == null) {
                    Boolean ignoreError = getIgnoreError();
                    Boolean ignoreError2 = naviSyncSettingsRequest.getIgnoreError();
                    if (ignoreError != null ? ignoreError.equals(ignoreError2) : ignoreError2 == null) {
                        List<DataOperation> dataList = getDataList();
                        List<DataOperation> dataList2 = naviSyncSettingsRequest.getDataList();
                        return dataList != null ? dataList.equals(dataList2) : dataList2 == null;
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
        Long localVersion = getLocalVersion();
        int hashCode = localVersion == null ? 43 : localVersion.hashCode();
        Boolean ignoreError = getIgnoreError();
        int hashCode2 = ((hashCode + 59) * 59) + (ignoreError == null ? 43 : ignoreError.hashCode());
        List<DataOperation> dataList = getDataList();
        return (hashCode2 * 59) + (dataList != null ? dataList.hashCode() : 43);
    }

    public NaviSyncSettingsRequest setDataList(List<DataOperation> list) {
        this.mDataList = list;
        return this;
    }

    public NaviSyncSettingsRequest setIgnoreError(Boolean bool) {
        this.mIgnoreError = bool;
        return this;
    }

    public NaviSyncSettingsRequest setLocalVersion(Long l) {
        this.mLocalVersion = l;
        return this;
    }

    public String toString() {
        return "NaviSyncSettingsRequest(mLocalVersion=" + getLocalVersion() + ", mIgnoreError=" + getIgnoreError() + ", mDataList=" + getDataList() + ")";
    }

    public Long getLocalVersion() {
        return this.mLocalVersion;
    }

    public Boolean getIgnoreError() {
        return this.mIgnoreError;
    }

    public List<DataOperation> getDataList() {
        return this.mDataList;
    }
}
