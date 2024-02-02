package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class LocPole implements Serializable {
    private float mAccuracy;
    private float mBx;
    private float mBy;
    private float mBz;
    private float mDiameter;
    private float mHeight;
    private float mTx;
    private float mTy;
    private int mType;
    private float mTz;

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public float getBx() {
        return this.mBx;
    }

    public void setBx(float f) {
        this.mBx = f;
    }

    public float getBy() {
        return this.mBy;
    }

    public void setBy(float f) {
        this.mBy = f;
    }

    public float getBz() {
        return this.mBz;
    }

    public void setBz(float f) {
        this.mBz = f;
    }

    public float getTx() {
        return this.mTx;
    }

    public void setTx(float f) {
        this.mTx = f;
    }

    public float getTy() {
        return this.mTy;
    }

    public void setTy(float f) {
        this.mTy = f;
    }

    public float getTz() {
        return this.mTz;
    }

    public void setTz(float f) {
        this.mTz = f;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public float getDiameter() {
        return this.mDiameter;
    }

    public void setDiameter(float f) {
        this.mDiameter = f;
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public void setAccuracy(float f) {
        this.mAccuracy = f;
    }
}
