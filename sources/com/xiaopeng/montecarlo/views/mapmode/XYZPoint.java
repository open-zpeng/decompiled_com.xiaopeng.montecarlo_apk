package com.xiaopeng.montecarlo.views.mapmode;
/* loaded from: classes3.dex */
public final class XYZPoint {
    private int mX;
    private int mY;
    private int mZ;

    public XYZPoint(int i, int i2, int i3) {
        this.mX = i;
        this.mY = i2;
        this.mZ = i3;
    }

    public int getX() {
        return this.mX;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public int getY() {
        return this.mY;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public int getZ() {
        return this.mZ;
    }

    public void setZ(int i) {
        this.mZ = i;
    }

    public String toString() {
        return "XYZPoint{mX=" + this.mX + ", mY=" + this.mY + ", mZ=" + this.mZ + '}';
    }
}
