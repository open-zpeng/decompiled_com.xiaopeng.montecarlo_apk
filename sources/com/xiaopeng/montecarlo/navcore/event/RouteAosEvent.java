package com.xiaopeng.montecarlo.navcore.event;

import com.autonavi.gbl.aosclient.model.BLResponseBase;
/* loaded from: classes3.dex */
public class RouteAosEvent {
    BLResponseBase mParam;

    public RouteAosEvent(BLResponseBase bLResponseBase) {
        this.mParam = bLResponseBase;
    }

    public BLResponseBase getParam() {
        return this.mParam;
    }
}
