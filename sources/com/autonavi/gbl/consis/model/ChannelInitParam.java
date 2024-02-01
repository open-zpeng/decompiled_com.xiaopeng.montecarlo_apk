package com.autonavi.gbl.consis.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChannelInitParam implements Serializable {
    public boolean enableConsis;
    public String host;
    public boolean isMaster;
    public String localSdkName;
    public int port;
    public boolean useInnerChannel;

    public ChannelInitParam() {
        this.isMaster = true;
        this.useInnerChannel = true;
        this.enableConsis = false;
        this.port = ChannelIpcId.ChannelIpcIdService;
        this.host = "";
        this.localSdkName = "";
    }

    public ChannelInitParam(boolean z, boolean z2, boolean z3, int i, String str, String str2) {
        this.isMaster = z;
        this.useInnerChannel = z2;
        this.enableConsis = z3;
        this.port = i;
        this.host = str;
        this.localSdkName = str2;
    }
}
