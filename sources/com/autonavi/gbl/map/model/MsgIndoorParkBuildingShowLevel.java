package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MsgIndoorParkBuildingShowLevel implements Serializable {
    public float maxLevel;
    public float minLevel;

    public MsgIndoorParkBuildingShowLevel() {
        this.minLevel = 17.0f;
        this.maxLevel = 20.0f;
    }

    public MsgIndoorParkBuildingShowLevel(float f, float f2) {
        this.minLevel = f;
        this.maxLevel = f2;
    }
}
