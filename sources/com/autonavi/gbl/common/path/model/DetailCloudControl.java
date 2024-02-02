package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DetailCloudControl implements Serializable {
    public long dtlType;
    public long id;
    public long prio;
    public long shwType;
    public long type;
    public long ver;

    public DetailCloudControl() {
        this.type = 0L;
        this.dtlType = 0L;
        this.id = 0L;
        this.shwType = 0L;
        this.prio = 0L;
        this.ver = 0L;
    }

    public DetailCloudControl(long j, long j2, long j3, long j4, long j5, long j6) {
        this.type = j;
        this.dtlType = j2;
        this.id = j3;
        this.shwType = j4;
        this.prio = j5;
        this.ver = j6;
    }
}
