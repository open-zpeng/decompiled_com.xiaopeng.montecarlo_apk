package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
@Deprecated
/* loaded from: classes2.dex */
public class NaviClearDataResponse {
    @SerializedName("server_version")
    private Long mServerVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviClearDataResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviClearDataResponse) {
            NaviClearDataResponse naviClearDataResponse = (NaviClearDataResponse) obj;
            if (naviClearDataResponse.canEqual(this)) {
                Long serverVersion = getServerVersion();
                Long serverVersion2 = naviClearDataResponse.getServerVersion();
                return serverVersion != null ? serverVersion.equals(serverVersion2) : serverVersion2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Long serverVersion = getServerVersion();
        return 59 + (serverVersion == null ? 43 : serverVersion.hashCode());
    }

    public NaviClearDataResponse setServerVersion(Long l) {
        this.mServerVersion = l;
        return this;
    }

    public String toString() {
        return "NaviClearDataResponse(mServerVersion=" + getServerVersion() + ")";
    }

    public Long getServerVersion() {
        return this.mServerVersion;
    }
}
