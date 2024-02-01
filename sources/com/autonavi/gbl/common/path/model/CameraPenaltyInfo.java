package com.autonavi.gbl.common.path.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CameraPenaltyInfo implements Serializable {
    public boolean isValid;
    public long onemonthCount;
    public long sevenCount;
    public long threeCount;
    public long threemonthCount;
    public long yesterCount;

    public CameraPenaltyInfo() {
        this.isValid = false;
        this.yesterCount = 0L;
        this.threeCount = 0L;
        this.sevenCount = 0L;
        this.onemonthCount = 0L;
        this.threemonthCount = 0L;
    }

    public CameraPenaltyInfo(boolean z, long j, long j2, long j3, long j4, long j5) {
        this.isValid = z;
        this.yesterCount = j;
        this.threeCount = j2;
        this.sevenCount = j3;
        this.onemonthCount = j4;
        this.threemonthCount = j5;
    }
}
