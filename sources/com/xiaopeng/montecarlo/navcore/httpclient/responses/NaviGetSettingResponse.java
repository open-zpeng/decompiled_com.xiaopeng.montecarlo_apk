package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.WebNaviSettingInfo;
import java.util.List;
@Deprecated
/* loaded from: classes3.dex */
public class NaviGetSettingResponse {
    @SerializedName("itemList")
    private List<WebNaviSettingInfo> mItemList;
    @SerializedName("localVersion")
    private Long mLocalVersion;
    @SerializedName("serverVersion")
    private Long mServerVersion;
    @SerializedName("sid")
    private String mSid;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviGetSettingResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviGetSettingResponse) {
            NaviGetSettingResponse naviGetSettingResponse = (NaviGetSettingResponse) obj;
            if (naviGetSettingResponse.canEqual(this)) {
                Long serverVersion = getServerVersion();
                Long serverVersion2 = naviGetSettingResponse.getServerVersion();
                if (serverVersion != null ? serverVersion.equals(serverVersion2) : serverVersion2 == null) {
                    Long localVersion = getLocalVersion();
                    Long localVersion2 = naviGetSettingResponse.getLocalVersion();
                    if (localVersion != null ? localVersion.equals(localVersion2) : localVersion2 == null) {
                        List<WebNaviSettingInfo> itemList = getItemList();
                        List<WebNaviSettingInfo> itemList2 = naviGetSettingResponse.getItemList();
                        if (itemList != null ? itemList.equals(itemList2) : itemList2 == null) {
                            String sid = getSid();
                            String sid2 = naviGetSettingResponse.getSid();
                            return sid != null ? sid.equals(sid2) : sid2 == null;
                        }
                        return false;
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
        Long localVersion = getLocalVersion();
        int hashCode2 = ((hashCode + 59) * 59) + (localVersion == null ? 43 : localVersion.hashCode());
        List<WebNaviSettingInfo> itemList = getItemList();
        int hashCode3 = (hashCode2 * 59) + (itemList == null ? 43 : itemList.hashCode());
        String sid = getSid();
        return (hashCode3 * 59) + (sid != null ? sid.hashCode() : 43);
    }

    public NaviGetSettingResponse setItemList(List<WebNaviSettingInfo> list) {
        this.mItemList = list;
        return this;
    }

    public NaviGetSettingResponse setLocalVersion(Long l) {
        this.mLocalVersion = l;
        return this;
    }

    public NaviGetSettingResponse setServerVersion(Long l) {
        this.mServerVersion = l;
        return this;
    }

    public NaviGetSettingResponse setSid(String str) {
        this.mSid = str;
        return this;
    }

    public String toString() {
        return "NaviGetSettingResponse(mServerVersion=" + getServerVersion() + ", mLocalVersion=" + getLocalVersion() + ", mItemList=" + getItemList() + ", mSid=" + getSid() + ")";
    }

    public Long getServerVersion() {
        return this.mServerVersion;
    }

    public Long getLocalVersion() {
        return this.mLocalVersion;
    }

    public List<WebNaviSettingInfo> getItemList() {
        return this.mItemList;
    }

    public String getSid() {
        return this.mSid;
    }
}
