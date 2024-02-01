package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class XPLocGyro implements Serializable {
    private int mInterval;
    private float mTemperature;
    private long mTickTime;
    private float mValueX;
    private float mValueY;
    private float mValueZ;

    public float getValueZ() {
        return this.mValueZ;
    }

    public void setValueZ(float f) {
        this.mValueZ = f;
    }

    public float getValueX() {
        return this.mValueX;
    }

    public void setValueX(float f) {
        this.mValueX = this.mValueX;
    }

    public float getValueY() {
        return this.mValueY;
    }

    public void setValueY(float f) {
        this.mValueY = f;
    }

    public float getTemperature() {
        return this.mTemperature;
    }

    public void setTemperature(float f) {
        this.mTemperature = f;
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
