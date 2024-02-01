package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class NakeEyeMapViewParam implements Serializable {
    public boolean enabled;
    public MapViewPortParam viewPortOfNake;
    public MapViewPortParam viewPortOfNormal;

    public NakeEyeMapViewParam() {
        this.enabled = false;
        this.viewPortOfNake = new MapViewPortParam();
        this.viewPortOfNormal = new MapViewPortParam();
    }

    public NakeEyeMapViewParam(boolean z, MapViewPortParam mapViewPortParam, MapViewPortParam mapViewPortParam2) {
        this.enabled = z;
        this.viewPortOfNake = mapViewPortParam;
        this.viewPortOfNormal = mapViewPortParam2;
    }
}
