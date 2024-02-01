package com.autonavi.gbl.map.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class CompassMarkerResourceInfo implements Serializable {
    public boolean billBoard;
    public int eastResID;
    public float eastScale;
    public int northResID;
    public float northScale;
    public int southResID;
    public float southScale;
    public int westResID;
    public float westScale;

    public CompassMarkerResourceInfo() {
        this.eastResID = -1;
        this.eastScale = 1.0f;
        this.southResID = -1;
        this.southScale = 1.0f;
        this.westResID = -1;
        this.westScale = 1.0f;
        this.northResID = -1;
        this.northScale = 1.0f;
        this.billBoard = false;
    }

    public CompassMarkerResourceInfo(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4, boolean z) {
        this.eastResID = i;
        this.eastScale = f;
        this.southResID = i2;
        this.southScale = f2;
        this.westResID = i3;
        this.westScale = f3;
        this.northResID = i4;
        this.northScale = f4;
        this.billBoard = z;
    }
}
