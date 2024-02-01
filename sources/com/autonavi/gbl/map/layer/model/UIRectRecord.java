package com.autonavi.gbl.map.layer.model;

import com.autonavi.gbl.common.model.RectDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class UIRectRecord implements Serializable {
    public float ratio;
    public RectDouble uiRect;

    public UIRectRecord() {
        this.uiRect = new RectDouble();
        this.ratio = 0.3f;
    }

    public UIRectRecord(RectDouble rectDouble, float f) {
        this.uiRect = rectDouble;
        this.ratio = f;
    }
}
