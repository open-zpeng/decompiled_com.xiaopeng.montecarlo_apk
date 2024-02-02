package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.SRType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SRObject implements Serializable {
    public float heading;
    public boolean isHighlight;
    public int modelResID;
    public int objectID;
    public RelativePos pos;
    @SRType.SRType1
    public int srType;
    public int textureResID;

    public SRObject() {
        this.objectID = -1;
        this.modelResID = -1;
        this.textureResID = -1;
        this.srType = 0;
        this.pos = new RelativePos();
        this.heading = 0.0f;
        this.isHighlight = false;
    }

    public SRObject(int i, int i2, int i3, @SRType.SRType1 int i4, RelativePos relativePos, float f, boolean z) {
        this.objectID = i;
        this.modelResID = i2;
        this.textureResID = i3;
        this.srType = i4;
        this.pos = relativePos;
        this.heading = f;
        this.isHighlight = z;
    }
}
