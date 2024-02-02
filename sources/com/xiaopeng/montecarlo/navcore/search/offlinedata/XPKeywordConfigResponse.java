package com.xiaopeng.montecarlo.navcore.search.offlinedata;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class XPKeywordConfigResponse {
    private static final L.Tag TAG = new L.Tag("XPKeywordConfigResponse");
    @SerializedName("data")
    private List<XPKeywordConfigInfo> mData;
    @SerializedName("version")
    private String mVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof XPKeywordConfigResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XPKeywordConfigResponse) {
            XPKeywordConfigResponse xPKeywordConfigResponse = (XPKeywordConfigResponse) obj;
            if (xPKeywordConfigResponse.canEqual(this)) {
                String version = getVersion();
                String version2 = xPKeywordConfigResponse.getVersion();
                if (version != null ? version.equals(version2) : version2 == null) {
                    List<XPKeywordConfigInfo> data = getData();
                    List<XPKeywordConfigInfo> data2 = xPKeywordConfigResponse.getData();
                    return data != null ? data.equals(data2) : data2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String version = getVersion();
        int hashCode = version == null ? 43 : version.hashCode();
        List<XPKeywordConfigInfo> data = getData();
        return ((hashCode + 59) * 59) + (data != null ? data.hashCode() : 43);
    }

    public void setData(List<XPKeywordConfigInfo> list) {
        this.mData = list;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "XPKeywordConfigResponse(mVersion=" + getVersion() + ", mData=" + getData() + ")";
    }

    public String getVersion() {
        return this.mVersion;
    }

    public List<XPKeywordConfigInfo> getData() {
        return this.mData;
    }
}
