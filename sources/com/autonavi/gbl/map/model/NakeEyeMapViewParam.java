package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class NakeEyeMapViewParam implements Serializable {
    public boolean Enabled;
    public MapViewPortParam ViewPortOfNake;
    public MapViewPortParam ViewPortOfNormal;

    public NakeEyeMapViewParam() {
        this.Enabled = false;
        this.ViewPortOfNake = new MapViewPortParam();
        this.ViewPortOfNormal = new MapViewPortParam();
    }

    public NakeEyeMapViewParam(boolean z, MapViewPortParam mapViewPortParam, MapViewPortParam mapViewPortParam2) {
        this.Enabled = z;
        this.ViewPortOfNake = mapViewPortParam;
        this.ViewPortOfNormal = mapViewPortParam2;
    }
}
