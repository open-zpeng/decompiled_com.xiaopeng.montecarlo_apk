package com.autonavi.gbl.scene.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ScreenParam implements Serializable {
    public int anchorX;
    public int anchorY;
    public boolean isInForeground;
    public float scaleFactor;
    public long skinMode;

    public ScreenParam() {
        this.scaleFactor = 1.0f;
        this.skinMode = 0L;
        this.isInForeground = true;
        this.anchorX = 0;
        this.anchorY = 0;
    }

    public ScreenParam(float f, long j, boolean z, int i, int i2) {
        this.scaleFactor = f;
        this.skinMode = j;
        this.isInForeground = z;
        this.anchorX = i;
        this.anchorY = i2;
    }
}
