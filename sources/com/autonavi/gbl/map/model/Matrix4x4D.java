package com.autonavi.gbl.map.model;
/* loaded from: classes.dex */
public class Matrix4x4D {
    public double[][] m;
    public double m11;
    public double m12;
    public double m13;
    public double m14;
    public double m21;
    public double m22;
    public double m23;
    public double m24;
    public double m31;
    public double m32;
    public double m33;
    public double m34;
    public double m41;
    public double m42;
    public double m43;
    public double m44;
    public double[] mat;

    public Matrix4x4D() {
        this.m11 = 0.0d;
        this.m12 = 0.0d;
        this.m13 = 0.0d;
        this.m14 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 0.0d;
        this.m23 = 0.0d;
        this.m24 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.m33 = 0.0d;
        this.m34 = 0.0d;
        this.m41 = 0.0d;
        this.m42 = 0.0d;
        this.m43 = 0.0d;
        this.m44 = 0.0d;
    }

    public Matrix4x4D(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double[][] dArr, double[] dArr2) {
        this.m11 = d;
        this.m12 = d2;
        this.m13 = d3;
        this.m14 = d4;
        this.m21 = d5;
        this.m22 = d6;
        this.m23 = d7;
        this.m24 = d8;
        this.m31 = d9;
        this.m32 = d10;
        this.m33 = d11;
        this.m34 = d12;
        this.m41 = d13;
        this.m42 = d14;
        this.m43 = d15;
        this.m44 = d16;
        this.m = dArr;
        this.mat = dArr2;
    }
}
