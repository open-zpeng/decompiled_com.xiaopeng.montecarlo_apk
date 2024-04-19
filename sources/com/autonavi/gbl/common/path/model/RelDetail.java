package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RelDetail implements Serializable {
    public long relId;
    public long relTp;

    public RelDetail() {
        this.relTp = 0L;
        this.relId = 0L;
    }

    public RelDetail(long j, long j2) {
        this.relTp = j;
        this.relId = j2;
    }
}
