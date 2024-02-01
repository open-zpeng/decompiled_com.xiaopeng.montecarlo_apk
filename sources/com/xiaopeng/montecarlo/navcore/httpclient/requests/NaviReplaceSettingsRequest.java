package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.ReplaceSettingInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class NaviReplaceSettingsRequest {
    @SerializedName("dataList")
    private List<ReplaceSettingInfo> mDataList;
    @SerializedName("ignoreError")
    private Boolean mIgnoreError;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviReplaceSettingsRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviReplaceSettingsRequest) {
            NaviReplaceSettingsRequest naviReplaceSettingsRequest = (NaviReplaceSettingsRequest) obj;
            if (naviReplaceSettingsRequest.canEqual(this)) {
                Boolean ignoreError = getIgnoreError();
                Boolean ignoreError2 = naviReplaceSettingsRequest.getIgnoreError();
                if (ignoreError != null ? ignoreError.equals(ignoreError2) : ignoreError2 == null) {
                    List<ReplaceSettingInfo> dataList = getDataList();
                    List<ReplaceSettingInfo> dataList2 = naviReplaceSettingsRequest.getDataList();
                    return dataList != null ? dataList.equals(dataList2) : dataList2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Boolean ignoreError = getIgnoreError();
        int hashCode = ignoreError == null ? 43 : ignoreError.hashCode();
        List<ReplaceSettingInfo> dataList = getDataList();
        return ((hashCode + 59) * 59) + (dataList != null ? dataList.hashCode() : 43);
    }

    public NaviReplaceSettingsRequest setDataList(List<ReplaceSettingInfo> list) {
        this.mDataList = list;
        return this;
    }

    public NaviReplaceSettingsRequest setIgnoreError(Boolean bool) {
        this.mIgnoreError = bool;
        return this;
    }

    public String toString() {
        return "NaviReplaceSettingsRequest(mIgnoreError=" + getIgnoreError() + ", mDataList=" + getDataList() + ")";
    }

    public Boolean getIgnoreError() {
        return this.mIgnoreError;
    }

    public List<ReplaceSettingInfo> getDataList() {
        return this.mDataList;
    }
}
