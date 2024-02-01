package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes3.dex */
public class BroadcastStyleBean {
    @SerializedName("data")
    private List<BroadcastMaskBean> mData;
    @SerializedName("version")
    private String mVersion;

    public void setData(List<BroadcastMaskBean> list) {
        this.mData = list;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public List<BroadcastMaskBean> getData() {
        return this.mData;
    }
}
