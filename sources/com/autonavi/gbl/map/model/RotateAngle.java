package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RotateAngle implements Serializable {
    public float xRotate;
    public float yRotate;
    public float zRotate;

    public RotateAngle() {
        this.xRotate = 0.0f;
        this.yRotate = 0.0f;
        this.zRotate = 0.0f;
    }

    public RotateAngle(float f, float f2, float f3) {
        this.xRotate = f;
        this.yRotate = f2;
        this.zRotate = f3;
    }
}
