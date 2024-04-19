package com.autonavi.gbl.pos.model;

import com.autonavi.gbl.pos.model.LocPoleType;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocPole implements Serializable {
    public float accuracy;
    public float bx;
    public float by;
    public float bz;
    public float diameter;
    public float height;
    public float tx;
    public float ty;
    @LocPoleType.LocPoleType1
    public int type;
    public float tz;

    public LocPole() {
        this.type = 0;
        this.bx = 0.0f;
        this.by = 0.0f;
        this.bz = 0.0f;
        this.tx = 0.0f;
        this.ty = 0.0f;
        this.tz = 0.0f;
        this.height = 0.0f;
        this.diameter = 0.0f;
        this.accuracy = 0.0f;
    }

    public LocPole(@LocPoleType.LocPoleType1 int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.type = i;
        this.bx = f;
        this.by = f2;
        this.bz = f3;
        this.tx = f4;
        this.ty = f5;
        this.tz = f6;
        this.height = f7;
        this.diameter = f8;
        this.accuracy = f9;
    }
}
