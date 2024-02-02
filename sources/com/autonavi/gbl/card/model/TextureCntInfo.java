package com.autonavi.gbl.card.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TextureCntInfo implements Serializable {
    public long capacityCnt;
    public long customUsedCnt;
    public long customUsedCntOfMe;
    public long staticUsedCnt;
    public long usedCnt;

    public TextureCntInfo() {
        this.capacityCnt = 0L;
        this.usedCnt = 0L;
        this.staticUsedCnt = 0L;
        this.customUsedCnt = 0L;
        this.customUsedCntOfMe = 0L;
    }

    public TextureCntInfo(long j, long j2, long j3, long j4, long j5) {
        this.capacityCnt = j;
        this.usedCnt = j2;
        this.staticUsedCnt = j3;
        this.customUsedCnt = j4;
        this.customUsedCntOfMe = j5;
    }
}
