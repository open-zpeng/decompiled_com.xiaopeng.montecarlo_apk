package com.xiaopeng.montecarlo.navcore.httpclient.responses;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.BoundAccountInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class NaviGetBoundAccountsResponse {
    @SerializedName("accounts")
    List<BoundAccountInfo> mAccounts;
    @SerializedName("sid")
    String mSid;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviGetBoundAccountsResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviGetBoundAccountsResponse) {
            NaviGetBoundAccountsResponse naviGetBoundAccountsResponse = (NaviGetBoundAccountsResponse) obj;
            if (naviGetBoundAccountsResponse.canEqual(this)) {
                List<BoundAccountInfo> accounts = getAccounts();
                List<BoundAccountInfo> accounts2 = naviGetBoundAccountsResponse.getAccounts();
                if (accounts != null ? accounts.equals(accounts2) : accounts2 == null) {
                    String sid = getSid();
                    String sid2 = naviGetBoundAccountsResponse.getSid();
                    return sid != null ? sid.equals(sid2) : sid2 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<BoundAccountInfo> accounts = getAccounts();
        int hashCode = accounts == null ? 43 : accounts.hashCode();
        String sid = getSid();
        return ((hashCode + 59) * 59) + (sid != null ? sid.hashCode() : 43);
    }

    public NaviGetBoundAccountsResponse setAccounts(List<BoundAccountInfo> list) {
        this.mAccounts = list;
        return this;
    }

    public NaviGetBoundAccountsResponse setSid(String str) {
        this.mSid = str;
        return this;
    }

    public String toString() {
        return "NaviGetBoundAccountsResponse(mAccounts=" + getAccounts() + ", mSid=" + getSid() + ")";
    }

    public List<BoundAccountInfo> getAccounts() {
        return this.mAccounts;
    }

    public String getSid() {
        return this.mSid;
    }
}
