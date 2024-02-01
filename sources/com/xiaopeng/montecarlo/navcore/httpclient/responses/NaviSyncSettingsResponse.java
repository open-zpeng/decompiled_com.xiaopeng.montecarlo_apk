package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.OperateSettingErrorDto;
import java.util.List;
@Deprecated
/* loaded from: classes3.dex */
public class NaviSyncSettingsResponse {
    @SerializedName("errorItemList")
    private List<OperateSettingErrorDto> mErrorItemList;
    @SerializedName("serverVersion")
    private Long mServerVersion;
    @SerializedName("successCount")
    private Integer mSuccessCount;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviSyncSettingsResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviSyncSettingsResponse) {
            NaviSyncSettingsResponse naviSyncSettingsResponse = (NaviSyncSettingsResponse) obj;
            if (naviSyncSettingsResponse.canEqual(this)) {
                Long serverVersion = getServerVersion();
                Long serverVersion2 = naviSyncSettingsResponse.getServerVersion();
                if (serverVersion != null ? serverVersion.equals(serverVersion2) : serverVersion2 == null) {
                    Integer successCount = getSuccessCount();
                    Integer successCount2 = naviSyncSettingsResponse.getSuccessCount();
                    if (successCount != null ? successCount.equals(successCount2) : successCount2 == null) {
                        List<OperateSettingErrorDto> errorItemList = getErrorItemList();
                        List<OperateSettingErrorDto> errorItemList2 = naviSyncSettingsResponse.getErrorItemList();
                        return errorItemList != null ? errorItemList.equals(errorItemList2) : errorItemList2 == null;
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
        Long serverVersion = getServerVersion();
        int hashCode = serverVersion == null ? 43 : serverVersion.hashCode();
        Integer successCount = getSuccessCount();
        int hashCode2 = ((hashCode + 59) * 59) + (successCount == null ? 43 : successCount.hashCode());
        List<OperateSettingErrorDto> errorItemList = getErrorItemList();
        return (hashCode2 * 59) + (errorItemList != null ? errorItemList.hashCode() : 43);
    }

    public NaviSyncSettingsResponse setErrorItemList(List<OperateSettingErrorDto> list) {
        this.mErrorItemList = list;
        return this;
    }

    public NaviSyncSettingsResponse setServerVersion(Long l) {
        this.mServerVersion = l;
        return this;
    }

    public NaviSyncSettingsResponse setSuccessCount(Integer num) {
        this.mSuccessCount = num;
        return this;
    }

    public String toString() {
        return "NaviSyncSettingsResponse(mServerVersion=" + getServerVersion() + ", mSuccessCount=" + getSuccessCount() + ", mErrorItemList=" + getErrorItemList() + ")";
    }

    public Long getServerVersion() {
        return this.mServerVersion;
    }

    public Integer getSuccessCount() {
        return this.mSuccessCount;
    }

    public List<OperateSettingErrorDto> getErrorItemList() {
        return this.mErrorItemList;
    }
}
