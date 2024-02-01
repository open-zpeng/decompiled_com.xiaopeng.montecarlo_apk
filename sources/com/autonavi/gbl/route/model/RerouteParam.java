package com.autonavi.gbl.route.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RerouteParam implements Serializable {
    public boolean enableAutoReroute;
    public boolean enableAutoSwitchParallelReroute;

    public RerouteParam() {
        this.enableAutoReroute = false;
        this.enableAutoSwitchParallelReroute = false;
    }

    public RerouteParam(boolean z, boolean z2) {
        this.enableAutoReroute = z;
        this.enableAutoSwitchParallelReroute = z2;
    }
}
