package com.xiaopeng.montecarlo.navcore.aos;

import com.autonavi.gbl.aosclient.model.BLResponseBase;
/* loaded from: classes2.dex */
public class AosEvent {
    BLResponseBase mResponseBase;

    public AosEvent(BLResponseBase bLResponseBase) {
        this.mResponseBase = bLResponseBase;
    }

    public BLResponseBase getResponseBase() {
        return this.mResponseBase;
    }

    public void setResponseBase(BLResponseBase bLResponseBase) {
        this.mResponseBase = bLResponseBase;
    }
}
