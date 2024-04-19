package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes2.dex */
public class NaviGetVersionResponse {
    @SerializedName("serverVersion")
    private Long mServerVersion;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviGetVersionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviGetVersionResponse) {
            NaviGetVersionResponse naviGetVersionResponse = (NaviGetVersionResponse) obj;
            if (naviGetVersionResponse.canEqual(this)) {
                Long serverVersion = getServerVersion();
                Long serverVersion2 = naviGetVersionResponse.getServerVersion();
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

    public NaviGetVersionResponse setServerVersion(Long l) {
        this.mServerVersion = l;
        return this;
    }

    public String toString() {
        return "NaviGetVersionResponse(mServerVersion=" + getServerVersion() + ")";
    }

    public Long getServerVersion() {
        return this.mServerVersion;
    }
}
