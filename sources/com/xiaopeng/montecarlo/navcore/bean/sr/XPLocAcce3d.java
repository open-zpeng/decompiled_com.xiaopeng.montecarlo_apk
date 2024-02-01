package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPLocAcce3d implements Serializable {
    private float mAcceX;
    private float mAcceY;
    private float mAcceZ;
    private int mInterval;
    private long mTickTime;

    public float getAcceZ() {
        return this.mAcceZ;
    }

    public void setAcceZ(float f) {
        this.mAcceZ = f;
    }

    public float getAcceX() {
        return this.mAcceX;
    }

    public void setAcceX(float f) {
        this.mAcceX = f;
    }

    public float getAcceY() {
        return this.mAcceY;
    }

    public void setAcceY(float f) {
        this.mAcceY = f;
    }

    public int getInterval() {
        return this.mInterval;
    }

    public void setInterval(int i) {
        this.mInterval = i;
    }

    public long getTickTime() {
        return this.mTickTime;
    }

    public void setTickTime(long j) {
        this.mTickTime = j;
    }
}
