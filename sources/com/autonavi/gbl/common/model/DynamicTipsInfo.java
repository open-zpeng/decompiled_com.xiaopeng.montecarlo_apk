package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DynamicTipsInfo implements Serializable {
    public String dynamicId;
    public long tipsType;
    public String title;
    public long weight;

    public DynamicTipsInfo() {
        this.dynamicId = "";
        this.tipsType = 0L;
        this.weight = 0L;
        this.title = "";
    }

    public DynamicTipsInfo(String str, long j, long j2, String str2) {
        this.dynamicId = str;
        this.tipsType = j;
        this.weight = j2;
        this.title = str2;
    }
}
