package com.xiaopeng.montecarlo.navcore.powerdistance;

import com.google.gson.annotations.SerializedName;
/* loaded from: classes3.dex */
public class EnergyInfo {
    public static final String AIRCONDITIONOFFK = "airConditionOffK";
    public static final String AIRCONDITIONONK = "airConditionOnK";
    public static final String RANGE = "range";
    @SerializedName("mRangeStart")
    private int mRangeStart = 0;
    @SerializedName("mRangeEnd")
    private int mRangeEnd = 0;
    @SerializedName("mAirConditionOnK")
    private float mAirConditionOnK = 1.0f;
    @SerializedName("mAirConditionOffK")
    private float mAirConditionOffK = 1.0f;

    public void setRangeStart(int i) {
        this.mRangeStart = i;
    }

    public int getRangeStart() {
        return this.mRangeStart;
    }

    public void setRangeEnd(int i) {
        this.mRangeEnd = i;
    }

    public int getRangeEnd() {
        return this.mRangeEnd;
    }

    public void setAirConditionOnK(float f) {
        this.mAirConditionOnK = f;
    }

    public float getAirConditionOnK() {
        return this.mAirConditionOnK;
    }

    public void setAirConditionOffK(float f) {
        this.mAirConditionOffK = f;
    }

    public float getAirConditionOffK() {
        return this.mAirConditionOffK;
    }
}
