package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes3.dex */
public class BroadcastMaskBean {
    @SerializedName("play_list")
    private List<Integer> mPlayList;
    @SerializedName("type")
    private String mType;

    public void setPlayList(List<Integer> list) {
        this.mPlayList = list;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    public List<Integer> getPlayList() {
        return this.mPlayList;
    }
}
