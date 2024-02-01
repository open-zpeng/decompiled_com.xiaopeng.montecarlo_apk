package com.autonavi.gbl.map.model;

import com.autonavi.gbl.map.model.MapviewMode;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapviewModeParam implements Serializable {
    public boolean bChangeCenter;
    public float mapZoomLevel;
    @MapviewMode.MapviewMode1
    public int mode;
    public float pitchAngle;

    public MapviewModeParam() {
        this.mode = 0;
        this.pitchAngle = -9999.0f;
        this.mapZoomLevel = -9999.0f;
        this.bChangeCenter = true;
    }

    public MapviewModeParam(@MapviewMode.MapviewMode1 int i, float f, float f2, boolean z) {
        this.mode = i;
        this.pitchAngle = f;
        this.mapZoomLevel = f2;
        this.bChangeCenter = z;
    }
}
