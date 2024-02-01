package com.xiaopeng.montecarlo.service.navi.type;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.scenes.routescene.RouteSaveState;
/* loaded from: classes3.dex */
public final class Result {
    @SerializedName("content")
    private String mContent;
    @SerializedName(RouteSaveState.KEY_ROUTE_REQUEST_ID)
    private int mRequestId;

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setRequestId(int i) {
        this.mRequestId = i;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public String toString() {
        return "Result{content='" + this.mContent + "', request_id=" + this.mRequestId + '}';
    }
}
