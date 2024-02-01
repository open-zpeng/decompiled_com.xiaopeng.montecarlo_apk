package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapPostureControlParam implements Serializable {
    public boolean isLockCarFollowMode;
    public boolean isLockMapDynamicLevel;

    public MapPostureControlParam() {
        this.isLockCarFollowMode = false;
        this.isLockMapDynamicLevel = false;
    }

    public MapPostureControlParam(boolean z, boolean z2) {
        this.isLockCarFollowMode = z;
        this.isLockMapDynamicLevel = z2;
    }
}
