package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.google.gson.annotations.SerializedName;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import java.util.List;
/* loaded from: classes2.dex */
public class BatteryPreHeatBean {
    public static final int DEST_TYPE_FAST_CHARGE_OTHER = 2;
    public static final int DEST_TYPE_FAST_CHARGE_XP = 1;
    public static final int DEST_TYPE_OTHER_CHARGE = 0;
    public static final int NAVIGATION_TYPE_CRUISE = 0;
    public static final int NAVIGATION_TYPE_EXPLORE = 2;
    public static final int NAVIGATION_TYPE_NAVI = 1;
    @SerializedName("kValue")
    private double mKValue;
    @SerializedName(CPSearchParam.PARAM_KEY_REMAIN_DIS)
    private long mRemainDis;
    @SerializedName("remainTime")
    private long mRemainTime;
    @SerializedName("roadSeqStages")
    private List<RoadSeqStages> mRoadSeqStages;
    @SerializedName("destType")
    private int mDestType = 0;
    @SerializedName("pathID")
    private long mPathID = 0;
    @SerializedName("navigationType")
    private int mNavigationType = 0;

    public void setDestType(int i) {
        this.mDestType = i;
    }

    public void setKValue(double d) {
        this.mKValue = d;
    }

    public void setNavigationType(int i) {
        this.mNavigationType = i;
    }

    public void setPathID(long j) {
        this.mPathID = j;
    }

    public void setRemainDis(long j) {
        this.mRemainDis = j;
    }

    public void setRemainTime(long j) {
        this.mRemainTime = j;
    }

    public void setRoadSeqStages(List<RoadSeqStages> list) {
        this.mRoadSeqStages = list;
    }

    public List<RoadSeqStages> getRoadSeqStages() {
        return this.mRoadSeqStages;
    }

    public int getDestType() {
        return this.mDestType;
    }

    public long getRemainDis() {
        return this.mRemainDis;
    }

    public long getRemainTime() {
        return this.mRemainTime;
    }

    public long getPathID() {
        return this.mPathID;
    }

    public int getNavigationType() {
        return this.mNavigationType;
    }

    public double getKValue() {
        return this.mKValue;
    }

    /* loaded from: classes2.dex */
    public static class RoadSeqStages {
        @SerializedName("ds")
        private long mDs;
        @SerializedName("ts")
        private long mTs;

        public void setDs(long j) {
            this.mDs = j;
        }

        public void setTs(long j) {
            this.mTs = j;
        }

        public long getDs() {
            return this.mDs;
        }

        public long getTs() {
            return this.mTs;
        }
    }
}
