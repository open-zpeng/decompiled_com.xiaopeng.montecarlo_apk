package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes2.dex */
public class NgpBroadcastStyleBean {
    @SerializedName("data")
    private List<NgpBroadcastPlayListBean> mData;
    @SerializedName("version")
    private String mVersion;

    public void setData(List<NgpBroadcastPlayListBean> list) {
        this.mData = list;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public List<NgpBroadcastPlayListBean> getData() {
        return this.mData;
    }
}
