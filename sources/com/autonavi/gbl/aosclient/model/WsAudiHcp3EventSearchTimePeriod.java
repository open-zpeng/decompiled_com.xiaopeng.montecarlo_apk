package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAudiHcp3EventSearchTimePeriod implements Serializable {
    public long endDate;
    public long startDate;

    public WsAudiHcp3EventSearchTimePeriod() {
        this.startDate = 0L;
        this.endDate = 0L;
    }

    public WsAudiHcp3EventSearchTimePeriod(long j, long j2) {
        this.startDate = j;
        this.endDate = j2;
    }
}
