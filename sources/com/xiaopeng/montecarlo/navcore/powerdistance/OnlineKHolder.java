package com.xiaopeng.montecarlo.navcore.powerdistance;
/* loaded from: classes2.dex */
public class OnlineKHolder {
    private double mK = 1.0d;

    public void setK(double d) {
        this.mK = d;
    }

    public double getK() {
        return this.mK * PowerDistanceManager.getInstance().getKAdjRate();
    }
}
