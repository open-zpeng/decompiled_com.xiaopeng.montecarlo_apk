package com.autonavi.gbl.scene.model;

import com.autonavi.gbl.common.model.RectDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ScenePreviewParam implements Serializable {
    public boolean bAdjustHeaderAngle;
    public boolean bInvalid;
    public int leftOfMap;
    public int mapAngleOffset;
    public RectDouble mapBound;
    public int screenBottom;
    public int screenLeft;
    public int screenRight;
    public int screenTop;
    public int targetMapRollAngle;
    public int topOfMap;

    public ScenePreviewParam() {
        this.bInvalid = false;
        this.mapBound = new RectDouble();
        this.leftOfMap = 0;
        this.topOfMap = 0;
        this.screenLeft = 0;
        this.screenTop = 0;
        this.screenRight = 0;
        this.screenBottom = 0;
        this.mapAngleOffset = 0;
        this.targetMapRollAngle = 0;
        this.bAdjustHeaderAngle = false;
    }

    public ScenePreviewParam(boolean z, RectDouble rectDouble, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2) {
        this.bInvalid = z;
        this.mapBound = rectDouble;
        this.leftOfMap = i;
        this.topOfMap = i2;
        this.screenLeft = i3;
        this.screenTop = i4;
        this.screenRight = i5;
        this.screenBottom = i6;
        this.mapAngleOffset = i7;
        this.targetMapRollAngle = i8;
        this.bAdjustHeaderAngle = z2;
    }
}
