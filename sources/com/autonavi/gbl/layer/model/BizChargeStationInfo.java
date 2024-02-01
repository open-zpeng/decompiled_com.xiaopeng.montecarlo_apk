package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class BizChargeStationInfo implements Serializable {
    public String brandDesc;
    public int fastFree;
    public int fastTotal;
    public boolean isQualityStation;
    public int slowFree;
    public int slowTotal;

    public BizChargeStationInfo() {
        this.isQualityStation = false;
        this.fastTotal = 0;
        this.fastFree = 0;
        this.slowTotal = 0;
        this.slowFree = -1;
        this.brandDesc = "";
    }

    public BizChargeStationInfo(boolean z, int i, int i2, int i3, int i4, String str) {
        this.isQualityStation = z;
        this.fastTotal = i;
        this.fastFree = i2;
        this.slowTotal = i3;
        this.slowFree = i4;
        this.brandDesc = str;
    }
}
