package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ProjectionCenter implements Serializable {
    public float percentX;
    public float percentY;

    public ProjectionCenter() {
        this.percentX = 0.0f;
        this.percentY = 0.0f;
    }

    public ProjectionCenter(float f, float f2) {
        this.percentX = f;
        this.percentY = f2;
    }
}
