package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes2.dex */
public class NgpBroadcastTypeBean {
    @SerializedName("soundType")
    private Integer mSoundType;
    @SerializedName("subSoundType")
    private List<Integer> mSubSoundType;

    public void setSoundType(Integer num) {
        this.mSoundType = num;
    }

    public void setSubSoundType(List<Integer> list) {
        this.mSubSoundType = list;
    }

    public Integer getSoundType() {
        return this.mSoundType;
    }

    public List<Integer> getSubSoundType() {
        return this.mSubSoundType;
    }
}
