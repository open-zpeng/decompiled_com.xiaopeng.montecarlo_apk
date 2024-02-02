package com.autonavi.gbl.layer.model;

import com.autonavi.gbl.common.model.Coord2DInt32;
import java.io.Serializable;
/* loaded from: classes.dex */
public class DynamicLevelCalcResult implements Serializable {
    public int pitchAngleDiffCount;
    public int screenCenterDiffCount;
    public float targetPitchAngle;
    public Coord2DInt32 targetScreenCenter;
    public float targetZoomLevel;
    public int zoomLevelDiffCount;

    public DynamicLevelCalcResult() {
        this.targetZoomLevel = -9999.0f;
        this.zoomLevelDiffCount = 10;
        this.targetPitchAngle = -9999.0f;
        this.pitchAngleDiffCount = 20;
        this.targetScreenCenter = new Coord2DInt32();
        this.screenCenterDiffCount = 0;
    }

    public DynamicLevelCalcResult(float f, int i, float f2, int i2, Coord2DInt32 coord2DInt32, int i3) {
        this.targetZoomLevel = f;
        this.zoomLevelDiffCount = i;
        this.targetPitchAngle = f2;
        this.pitchAngleDiffCount = i2;
        this.targetScreenCenter = coord2DInt32;
        this.screenCenterDiffCount = i3;
    }
}
