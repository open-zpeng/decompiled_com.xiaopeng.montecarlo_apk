package com.autonavi.gbl.common.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DynamicTips implements Serializable {
    public long reqId;
    public ArrayList<DynamicTipsInfo> tipsInfo;

    public DynamicTips() {
        this.tipsInfo = new ArrayList<>();
        this.reqId = 0L;
    }

    public DynamicTips(ArrayList<DynamicTipsInfo> arrayList, long j) {
        this.tipsInfo = arrayList;
        this.reqId = j;
    }
}
