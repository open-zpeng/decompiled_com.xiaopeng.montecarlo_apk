package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes3.dex */
public class NgpBroadcastPlayListBean {
    @SerializedName("play_list")
    private List<NgpBroadcastTypeBean> mPlayList;
    @SerializedName("type")
    private String mType;

    public void setPlayList(List<NgpBroadcastTypeBean> list) {
        this.mPlayList = list;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    public List<NgpBroadcastTypeBean> getPlayList() {
        return this.mPlayList;
    }
}
