package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Matrix4x4F implements Serializable {
    public float[][] m;
    public float m11;
    public float m12;
    public float m13;
    public float m14;
    public float m21;
    public float m22;
    public float m23;
    public float m24;
    public float m31;
    public float m32;
    public float m33;
    public float m34;
    public float m41;
    public float m42;
    public float m43;
    public float m44;
    public float[] mat;

    public Matrix4x4F() {
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m14 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m24 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
        this.m34 = 0.0f;
        this.m41 = 0.0f;
        this.m42 = 0.0f;
        this.m43 = 0.0f;
        this.m44 = 0.0f;
    }

    public Matrix4x4F(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float[][] fArr, float[] fArr2) {
        this.m11 = f;
        this.m12 = f2;
        this.m13 = f3;
        this.m14 = f4;
        this.m21 = f5;
        this.m22 = f6;
        this.m23 = f7;
        this.m24 = f8;
        this.m31 = f9;
        this.m32 = f10;
        this.m33 = f11;
        this.m34 = f12;
        this.m41 = f13;
        this.m42 = f14;
        this.m43 = f15;
        this.m44 = f16;
        this.m = fArr;
        this.mat = fArr2;
    }
}
