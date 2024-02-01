package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.xiaopeng.montecarlo.navcore.httpclient.dto.OperateSettingErrorDto;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
/* loaded from: classes3.dex */
public class NaviReplaceSettingsResponse {
    private List<OperateSettingErrorDto> mErrorItemList;
    @NotNull
    @Valid
    private Long mServerVersion;
    private Integer mSuccessCount;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviReplaceSettingsResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviReplaceSettingsResponse) {
            NaviReplaceSettingsResponse naviReplaceSettingsResponse = (NaviReplaceSettingsResponse) obj;
            if (naviReplaceSettingsResponse.canEqual(this)) {
                Long serverVersion = getServerVersion();
                Long serverVersion2 = naviReplaceSettingsResponse.getServerVersion();
                if (serverVersion != null ? serverVersion.equals(serverVersion2) : serverVersion2 == null) {
                    Integer successCount = getSuccessCount();
                    Integer successCount2 = naviReplaceSettingsResponse.getSuccessCount();
                    if (successCount != null ? successCount.equals(successCount2) : successCount2 == null) {
                        List<OperateSettingErrorDto> errorItemList = getErrorItemList();
                        List<OperateSettingErrorDto> errorItemList2 = naviReplaceSettingsResponse.getErrorItemList();
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

    public NaviReplaceSettingsResponse setErrorItemList(List<OperateSettingErrorDto> list) {
        this.mErrorItemList = list;
        return this;
    }

    public NaviReplaceSettingsResponse setServerVersion(Long l) {
        this.mServerVersion = l;
        return this;
    }

    public NaviReplaceSettingsResponse setSuccessCount(Integer num) {
        this.mSuccessCount = num;
        return this;
    }

    public String toString() {
        return "NaviReplaceSettingsResponse(mServerVersion=" + getServerVersion() + ", mSuccessCount=" + getSuccessCount() + ", mErrorItemList=" + getErrorItemList() + ")";
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
