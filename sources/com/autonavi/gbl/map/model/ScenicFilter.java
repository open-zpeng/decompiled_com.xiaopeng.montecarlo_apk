package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ScenicFilter implements Serializable {
    public long mainKey;
    public long poiFlag;
    public long subKey;

    public ScenicFilter() {
        this.mainKey = 0L;
        this.subKey = 0L;
        this.poiFlag = 0L;
    }

    public ScenicFilter(long j, long j2, long j3) {
        this.mainKey = j;
        this.subKey = j2;
        this.poiFlag = j3;
    }
}
