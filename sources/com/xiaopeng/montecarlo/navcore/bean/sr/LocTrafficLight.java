package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class LocTrafficLight implements Serializable {
    private float mAccuracy;
    private float mHeight;
    private float mWidth;
    private float mX;
    private float mY;
    private float mZ;

    public float getX() {
        return this.mX;
    }

    public void setX(float f) {
        this.mX = f;
    }

    public float getY() {
        return this.mY;
    }

    public void setY(float f) {
        this.mY = f;
    }

    public float getZ() {
        return this.mZ;
    }

    public void setZ(float f) {
        this.mZ = f;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public void setAccuracy(float f) {
        this.mAccuracy = f;
    }
}
