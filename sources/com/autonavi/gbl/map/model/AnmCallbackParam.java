package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class AnmCallbackParam implements Serializable {
    public long animationID;
    public int animationType;
    public int anmAnimationState;
    public int anmChangeContent;
    public boolean mapCanAddZoomAnm;

    public AnmCallbackParam() {
        this.animationID = 0L;
        this.animationType = 0;
        this.anmChangeContent = 0;
        this.anmAnimationState = 0;
        this.mapCanAddZoomAnm = false;
    }

    public AnmCallbackParam(long j, int i, int i2, int i3, boolean z) {
        this.animationID = j;
        this.animationType = i;
        this.anmChangeContent = i2;
        this.anmAnimationState = i3;
        this.mapCanAddZoomAnm = z;
    }
}
