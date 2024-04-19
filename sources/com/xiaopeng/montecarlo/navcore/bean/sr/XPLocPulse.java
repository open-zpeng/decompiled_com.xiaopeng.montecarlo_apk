package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPLocPulse implements Serializable {
    private int mInterval;
    private long mTickTime;
    private float mValue;
    private float mVfl;
    private float mVfr;
    private float mVrl;
    private float mVrr;

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f) {
        this.mValue = f;
    }

    public float getVrl() {
        return this.mVrl;
    }

    public void setVrl(float f) {
        this.mVrl = f;
    }

    public float getVrr() {
        return this.mVrr;
    }

    public void setVrr(float f) {
        this.mVrr = f;
    }

    public float getVfl() {
        return this.mVfl;
    }

    public void setVfl(float f) {
        this.mVfl = f;
    }

    public float getVfr() {
        return this.mVfr;
    }

    public void setVfr(float f) {
        this.mVfr = f;
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
