package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Point3F implements Serializable {
    public float x;
    public float y;
    public float z;

    public Point3F() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public Point3F(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }
}
