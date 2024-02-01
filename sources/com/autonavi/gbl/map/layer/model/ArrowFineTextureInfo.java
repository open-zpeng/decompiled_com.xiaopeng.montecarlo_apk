package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ArrowFineTextureInfo implements Serializable {
    public boolean drawFineArrow;
    public float hangWidthRatio;
    public float headAngle;
    public float headWidthRatio;
    public float heightWidthRatio;
    public long purfleColor1;
    public long purfleColor2;
    public float purfleWidthRatio1;
    public float purfleWidthRatio2;
    public long shadowColor;
    public float shadowPurfleWidthRatio;
    public long surfaceColor;
    public long wallColor;
    public float width;

    public ArrowFineTextureInfo() {
        this.drawFineArrow = false;
        this.headAngle = 60.0f;
        this.width = 100.0f;
        this.headWidthRatio = 3.0f;
        this.hangWidthRatio = 0.2f;
        this.heightWidthRatio = 0.4f;
        this.purfleWidthRatio1 = 0.1f;
        this.purfleWidthRatio2 = 0.2f;
        this.shadowPurfleWidthRatio = 0.3f;
        this.surfaceColor = -1L;
        this.purfleColor1 = -1L;
        this.purfleColor2 = -1L;
        this.wallColor = -1L;
        this.shadowColor = -1L;
    }

    public ArrowFineTextureInfo(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, long j, long j2, long j3, long j4, long j5) {
        this.drawFineArrow = z;
        this.headAngle = f;
        this.width = f2;
        this.headWidthRatio = f3;
        this.hangWidthRatio = f4;
        this.heightWidthRatio = f5;
        this.purfleWidthRatio1 = f6;
        this.purfleWidthRatio2 = f7;
        this.shadowPurfleWidthRatio = f8;
        this.surfaceColor = j;
        this.purfleColor1 = j2;
        this.purfleColor2 = j3;
        this.wallColor = j4;
        this.shadowColor = j5;
    }
}
