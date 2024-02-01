package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class RectFloat implements Serializable {
    public float bottom;
    public float left;
    public float right;
    public float top;

    public RectFloat() {
        this.left = 0.0f;
        this.right = 0.0f;
        this.top = 0.0f;
        this.bottom = 0.0f;
    }

    public RectFloat(float f, float f2, float f3, float f4) {
        this.left = f;
        this.right = f2;
        this.top = f3;
        this.bottom = f4;
    }
}
