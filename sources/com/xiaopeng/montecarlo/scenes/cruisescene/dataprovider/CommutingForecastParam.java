package com.xiaopeng.montecarlo.scenes.cruisescene.dataprovider;
/* loaded from: classes3.dex */
public class CommutingForecastParam extends CruiseRequestParam {
    private int mCount;
    private int mPeriod;
    private final int mStart = 0;
    private final int mInitialDelay = 0;

    public int getInitialDelay() {
        return 0;
    }

    public int getStart() {
        return 0;
    }

    public int getPeriod() {
        return this.mPeriod;
    }

    public void setPeriod(int i) {
        this.mPeriod = i;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        this.mCount = i;
    }
}
