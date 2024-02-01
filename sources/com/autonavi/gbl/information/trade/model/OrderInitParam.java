package com.autonavi.gbl.information.trade.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class OrderInitParam implements Serializable {
    public boolean isPoll;
    public long maxPoll;
    public long pollInterval;

    public OrderInitParam() {
        this.isPoll = false;
        this.maxPoll = 300L;
        this.pollInterval = 1000L;
    }

    public OrderInitParam(boolean z, long j, long j2) {
        this.isPoll = z;
        this.maxPoll = j;
        this.pollInterval = j2;
    }
}
