package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class STTipsBaseElement implements Serializable {
    public long type;
    public long typeId;
    public long ver;

    public STTipsBaseElement() {
        this.typeId = 0L;
        this.type = 0L;
        this.ver = 0L;
    }

    public STTipsBaseElement(long j, long j2, long j3) {
        this.typeId = j;
        this.type = j2;
        this.ver = j3;
    }
}
