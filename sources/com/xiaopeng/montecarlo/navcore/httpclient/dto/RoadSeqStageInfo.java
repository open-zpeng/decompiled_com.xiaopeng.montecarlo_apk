package com.xiaopeng.montecarlo.navcore.httpclient.dto;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class RoadSeqStageInfo {
    @SerializedName("ds")
    private long mDs;
    @SerializedName("ts")
    private long mTs;

    protected boolean canEqual(Object obj) {
        return obj instanceof RoadSeqStageInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RoadSeqStageInfo) {
            RoadSeqStageInfo roadSeqStageInfo = (RoadSeqStageInfo) obj;
            return roadSeqStageInfo.canEqual(this) && getDs() == roadSeqStageInfo.getDs() && getTs() == roadSeqStageInfo.getTs();
        }
        return false;
    }

    public int hashCode() {
        long ds = getDs();
        long ts = getTs();
        return ((((int) (ds ^ (ds >>> 32))) + 59) * 59) + ((int) ((ts >>> 32) ^ ts));
    }

    public RoadSeqStageInfo setDs(long j) {
        this.mDs = j;
        return this;
    }

    public RoadSeqStageInfo setTs(long j) {
        this.mTs = j;
        return this;
    }

    public String toString() {
        return "RoadSeqStageInfo(mDs=" + getDs() + ", mTs=" + getTs() + ")";
    }

    public long getDs() {
        return this.mDs;
    }

    public long getTs() {
        return this.mTs;
    }

    public double getSpeed() {
        return (((float) this.mDs) / ((float) this.mTs)) * 3.6d;
    }
}
