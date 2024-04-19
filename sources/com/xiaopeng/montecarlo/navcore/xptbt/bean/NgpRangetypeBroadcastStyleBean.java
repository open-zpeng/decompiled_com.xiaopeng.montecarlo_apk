package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes3.dex */
public class NgpRangetypeBroadcastStyleBean {
    @SerializedName("data")
    private List<NgpRangetypeBroadcastPlaylistBean> mData;
    @SerializedName("version")
    private String mVersion;

    public void setData(List<NgpRangetypeBroadcastPlaylistBean> list) {
        this.mData = list;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public List<NgpRangetypeBroadcastPlaylistBean> getData() {
        return this.mData;
    }
}
