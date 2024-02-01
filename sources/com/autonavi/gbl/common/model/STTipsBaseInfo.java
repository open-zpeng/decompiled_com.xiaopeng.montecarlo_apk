package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class STTipsBaseInfo implements Serializable {
    public STTipsBaseElement element;
    public int pathIdx;
    public long prio;
    public long shwType;

    public STTipsBaseInfo() {
        this.element = new STTipsBaseElement();
        this.pathIdx = 0;
        this.shwType = 0L;
        this.prio = 0L;
    }

    public STTipsBaseInfo(STTipsBaseElement sTTipsBaseElement, int i, long j, long j2) {
        this.element = sTTipsBaseElement;
        this.pathIdx = i;
        this.shwType = j;
        this.prio = j2;
    }
}
