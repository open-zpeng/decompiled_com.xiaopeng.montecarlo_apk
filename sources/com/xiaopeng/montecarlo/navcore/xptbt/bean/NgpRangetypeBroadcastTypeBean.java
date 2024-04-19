package com.xiaopeng.montecarlo.navcore.xptbt.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/* loaded from: classes3.dex */
public class NgpRangetypeBroadcastTypeBean {
    @SerializedName("rangeType")
    private List<Integer> mRangeType;

    public void setRangeType(List<Integer> list) {
        this.mRangeType = list;
    }

    public List<Integer> getRangeType() {
        return this.mRangeType;
    }
}
