package com.autonavi.gbl.lane.model;

import com.autonavi.gbl.lane.model.SRType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class SRObjectRenderInfo implements Serializable {
    public int objectID;
    public RelativePos pos;
    @SRType.SRType1
    public int type;

    public SRObjectRenderInfo() {
        this.pos = new RelativePos();
        this.objectID = -1;
        this.type = 0;
    }

    public SRObjectRenderInfo(RelativePos relativePos, int i, @SRType.SRType1 int i2) {
        this.pos = relativePos;
        this.objectID = i;
        this.type = i2;
    }
}
