package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsEventSearchTimePeriod implements Serializable {
    public long endDate;
    public long startDate;

    public WsEventSearchTimePeriod() {
        this.startDate = 0L;
        this.endDate = 0L;
    }

    public WsEventSearchTimePeriod(long j, long j2) {
        this.startDate = j;
        this.endDate = j2;
    }
}
