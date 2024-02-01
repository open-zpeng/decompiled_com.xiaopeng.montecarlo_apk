package com.autonavi.gbl.pos.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocTrafficLight implements Serializable {
    public float accuracy;
    public float height;
    public float width;
    public float x;
    public float y;
    public float z;

    public LocTrafficLight() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.accuracy = 0.0f;
    }

    public LocTrafficLight(float f, float f2, float f3, float f4, float f5, float f6) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.width = f4;
        this.height = f5;
        this.accuracy = f6;
    }
}
