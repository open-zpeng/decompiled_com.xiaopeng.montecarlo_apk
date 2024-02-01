package com.autonavi.gbl.route.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Online2OfflineInfo implements Serializable {
    public long curRequestId;
    public boolean isProducedByBLOnlineToOffline;
    public boolean isRetryingRequestByBL;
    public long lastRequestId;

    public Online2OfflineInfo() {
        this.isProducedByBLOnlineToOffline = false;
        this.lastRequestId = 0L;
        this.isRetryingRequestByBL = false;
        this.curRequestId = 0L;
    }

    public Online2OfflineInfo(boolean z, long j, boolean z2, long j2) {
        this.isProducedByBLOnlineToOffline = z;
        this.lastRequestId = j;
        this.isRetryingRequestByBL = z2;
        this.curRequestId = j2;
    }
}
