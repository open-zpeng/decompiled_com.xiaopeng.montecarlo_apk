package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocReroute implements Serializable {
    public long count;
    public byte[] rerouteInfo;

    public LocReroute() {
        this.count = 0L;
        this.rerouteInfo = new byte[200];
    }

    public LocReroute(byte[] bArr, long j) {
        this.rerouteInfo = bArr;
        this.count = j;
    }
}
