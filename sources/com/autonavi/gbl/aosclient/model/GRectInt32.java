package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRectInt32 implements Serializable {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public GRectInt32() {
        this.left = 0;
        this.right = 0;
        this.top = 0;
        this.bottom = 0;
    }

    public GRectInt32(int i, int i2, int i3, int i4) {
        this.left = i;
        this.right = i2;
        this.top = i3;
        this.bottom = i4;
    }
}
