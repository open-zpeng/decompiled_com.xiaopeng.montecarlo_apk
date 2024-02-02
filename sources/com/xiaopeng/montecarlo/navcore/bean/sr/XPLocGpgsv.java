package com.xiaopeng.montecarlo.navcore.bean.sr;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class XPLocGpgsv implements Serializable {
    private int[] mAzimuth;
    private int[] mElevation;
    private int mNum;
    private int[] mPrn;
    private int[] mSnr;
    private long mTickTime;
    private int mType;

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getNum() {
        return this.mNum;
    }

    public void setNum(int i) {
        this.mNum = i;
    }

    public int[] getPrn() {
        return this.mPrn;
    }

    public void setPrn(int[] iArr) {
        this.mPrn = iArr;
    }

    public int[] getElevation() {
        return this.mElevation;
    }

    public void setElevation(int[] iArr) {
        this.mElevation = iArr;
    }

    public int[] getAzimuth() {
        return this.mAzimuth;
    }

    public void setAzimuth(int[] iArr) {
        this.mAzimuth = iArr;
    }

    public int[] getSnr() {
        return this.mSnr;
    }

    public void setSnr(int[] iArr) {
        this.mSnr = iArr;
    }

    public long getTickTime() {
        return this.mTickTime;
    }

    public void setTickTime(long j) {
        this.mTickTime = j;
    }
}
