package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMSyncDataExtend implements Serializable {
    private static final long serialVersionUID = -8616277044849652198L;
    public boolean isFailover;
    public long minCreateTime;

    public AIMSyncDataExtend(long j, boolean z) {
        this.minCreateTime = -1L;
        this.isFailover = false;
        this.minCreateTime = j;
        this.isFailover = z;
    }

    public AIMSyncDataExtend() {
        this.minCreateTime = -1L;
        this.isFailover = false;
    }

    public long getMinCreateTime() {
        return this.minCreateTime;
    }

    public boolean getIsFailover() {
        return this.isFailover;
    }

    public String toString() {
        return "AIMSyncDataExtend{minCreateTime=" + this.minCreateTime + ",isFailover=" + this.isFailover + "}";
    }
}
