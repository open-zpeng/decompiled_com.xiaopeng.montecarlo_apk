package com.xiaopeng.montecarlo.navcore.httpclient.requests;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviMultiQueryRequest {
    @SerializedName("request_list")
    private List<NaviQueryRequest> mRequestList;
    @SerializedName("type")
    private int mType;

    protected boolean canEqual(Object obj) {
        return obj instanceof NaviMultiQueryRequest;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NaviMultiQueryRequest) {
            NaviMultiQueryRequest naviMultiQueryRequest = (NaviMultiQueryRequest) obj;
            if (naviMultiQueryRequest.canEqual(this) && getType() == naviMultiQueryRequest.getType()) {
                List<NaviQueryRequest> requestList = getRequestList();
                List<NaviQueryRequest> requestList2 = naviMultiQueryRequest.getRequestList();
                return requestList != null ? requestList.equals(requestList2) : requestList2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<NaviQueryRequest> requestList = getRequestList();
        return ((getType() + 59) * 59) + (requestList == null ? 43 : requestList.hashCode());
    }

    public NaviMultiQueryRequest setRequestList(List<NaviQueryRequest> list) {
        this.mRequestList = list;
        return this;
    }

    public NaviMultiQueryRequest setType(int i) {
        this.mType = i;
        return this;
    }

    public String toString() {
        return "NaviMultiQueryRequest(mType=" + getType() + ", mRequestList=" + getRequestList() + ")";
    }

    public int getType() {
        return this.mType;
    }

    public List<NaviQueryRequest> getRequestList() {
        return this.mRequestList;
    }
}
