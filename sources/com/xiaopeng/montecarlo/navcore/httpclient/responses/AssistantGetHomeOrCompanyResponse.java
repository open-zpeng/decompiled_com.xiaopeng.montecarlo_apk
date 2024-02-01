package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.HomeOrCompanyInfo;
/* loaded from: classes3.dex */
public class AssistantGetHomeOrCompanyResponse {
    @SerializedName("find")
    boolean mFind;
    @SerializedName("info")
    HomeOrCompanyInfo mInfo;

    protected boolean canEqual(Object obj) {
        return obj instanceof AssistantGetHomeOrCompanyResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssistantGetHomeOrCompanyResponse) {
            AssistantGetHomeOrCompanyResponse assistantGetHomeOrCompanyResponse = (AssistantGetHomeOrCompanyResponse) obj;
            if (assistantGetHomeOrCompanyResponse.canEqual(this) && isFind() == assistantGetHomeOrCompanyResponse.isFind()) {
                HomeOrCompanyInfo info = getInfo();
                HomeOrCompanyInfo info2 = assistantGetHomeOrCompanyResponse.getInfo();
                return info != null ? info.equals(info2) : info2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = isFind() ? 79 : 97;
        HomeOrCompanyInfo info = getInfo();
        return ((i + 59) * 59) + (info == null ? 43 : info.hashCode());
    }

    public AssistantGetHomeOrCompanyResponse setFind(boolean z) {
        this.mFind = z;
        return this;
    }

    public AssistantGetHomeOrCompanyResponse setInfo(HomeOrCompanyInfo homeOrCompanyInfo) {
        this.mInfo = homeOrCompanyInfo;
        return this;
    }

    public String toString() {
        return "AssistantGetHomeOrCompanyResponse(mFind=" + isFind() + ", mInfo=" + getInfo() + ")";
    }

    public boolean isFind() {
        return this.mFind;
    }

    public HomeOrCompanyInfo getInfo() {
        return this.mInfo;
    }
}
