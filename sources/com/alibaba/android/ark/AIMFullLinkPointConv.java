package com.alibaba.android.ark;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AIMFullLinkPointConv {
    public AIMFullLinkPointBase basePoint;
    public ArrayList<AIMTraceConvInfo> convInfos;

    public AIMFullLinkPointConv(AIMFullLinkPointBase aIMFullLinkPointBase, ArrayList<AIMTraceConvInfo> arrayList) {
        this.basePoint = aIMFullLinkPointBase;
        this.convInfos = arrayList;
    }

    public AIMFullLinkPointConv() {
    }

    public AIMFullLinkPointBase getBasePoint() {
        return this.basePoint;
    }

    public ArrayList<AIMTraceConvInfo> getConvInfos() {
        return this.convInfos;
    }

    public String toString() {
        return "AIMFullLinkPointConv{basePoint=" + this.basePoint + ",convInfos=" + this.convInfos + "}";
    }
}
