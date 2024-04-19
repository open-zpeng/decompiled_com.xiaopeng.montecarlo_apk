package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes3.dex */
public class NgpRangetypeBroadcastPlaylistBean {
    @SerializedName("play_list")
    private List<NgpRangetypeBroadcastTypeBean> mPlayList;
    @SerializedName("type")
    private String mType;

    public void setPlayList(List<NgpRangetypeBroadcastTypeBean> list) {
        this.mPlayList = list;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    public List<NgpRangetypeBroadcastTypeBean> getPlayList() {
        return this.mPlayList;
    }
}
