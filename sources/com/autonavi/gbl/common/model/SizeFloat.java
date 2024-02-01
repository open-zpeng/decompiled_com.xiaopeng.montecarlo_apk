package com.autonavi.gbl.common.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class SizeFloat implements Serializable {
    public float height;
    public float width;

    public SizeFloat() {
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public SizeFloat(float f, float f2) {
        this.width = f;
        this.height = f2;
    }
}
