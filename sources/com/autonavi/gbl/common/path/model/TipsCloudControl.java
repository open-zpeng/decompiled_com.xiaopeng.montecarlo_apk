package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class TipsCloudControl implements Serializable {
    public long id;
    public int pathIdx;
    public long prio;
    public long shwType;
    public long tipType;
    public long type;
    public long ver;

    public TipsCloudControl() {
        this.type = 0L;
        this.tipType = 0L;
        this.id = 0L;
        this.shwType = 0L;
        this.pathIdx = 0;
        this.prio = 0L;
        this.ver = 0L;
    }

    public TipsCloudControl(long j, long j2, long j3, long j4, int i, long j5, long j6) {
        this.type = j;
        this.tipType = j2;
        this.id = j3;
        this.shwType = j4;
        this.pathIdx = i;
        this.prio = j5;
        this.ver = j6;
    }
}
