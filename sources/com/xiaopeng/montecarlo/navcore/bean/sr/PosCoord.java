package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PosCoord implements Serializable {
    private double mAlt;
    private double mLat;
    private double mLon;

    public double getLon() {
        return this.mLon;
    }

    public void setLon(double d) {
        this.mLon = d;
    }

    public double getLat() {
        return this.mLat;
    }

    public void setLat(double d) {
        this.mLat = d;
    }

    public double getAlt() {
        return this.mAlt;
    }

    public void setAlt(double d) {
        this.mAlt = d;
    }
}
