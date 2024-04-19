package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocMarkingType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocMarking implements Serializable {
    public float accuracy;
    public float height;
    @LocMarkingType.LocMarkingType1
    public int type;
    public float width;
    public float x;
    public float y;
    public float z;

    public LocMarking() {
        this.type = 0;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.accuracy = 0.0f;
    }

    public LocMarking(@LocMarkingType.LocMarkingType1 int i, float f, float f2, float f3, float f4, float f5, float f6) {
        this.type = i;
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.width = f4;
        this.height = f5;
        this.accuracy = f6;
    }
}
