package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class UpLoadLink implements Serializable {
    public int offset;
    public long topoID;

    public UpLoadLink() {
        this.topoID = 0L;
        this.offset = 0;
    }

    public UpLoadLink(long j, int i) {
        this.topoID = j;
        this.offset = i;
    }
}
