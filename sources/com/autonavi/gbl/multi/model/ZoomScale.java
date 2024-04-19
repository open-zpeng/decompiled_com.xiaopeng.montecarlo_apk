package com.autonavi.gbl.multi.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ZoomScale implements Serializable {
    public float dpi;
    public float longitudePerPixel;

    public ZoomScale() {
        this.longitudePerPixel = 0.0f;
        this.dpi = 0.0f;
    }

    public ZoomScale(float f, float f2) {
        this.longitudePerPixel = f;
        this.dpi = f2;
    }
}
