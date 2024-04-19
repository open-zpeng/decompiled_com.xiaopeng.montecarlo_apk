package com.autonavi.gbl.consis.model;
/* loaded from: classes.dex */
public class ConnectMsgHead {
    public long clientIpcId;
    public boolean isServer;
    public long serverIpcId;

    public ConnectMsgHead() {
        this.isServer = false;
        this.clientIpcId = 0L;
        this.serverIpcId = 0L;
    }

    public ConnectMsgHead(boolean z, long j, long j2) {
        this.isServer = z;
        this.clientIpcId = j;
        this.serverIpcId = j2;
    }
}
