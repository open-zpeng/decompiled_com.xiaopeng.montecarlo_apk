package com.autonavi.gbl.user.behavior.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TruckInfo implements Serializable {
    public int n32AxleNum;
    public int n32Emission;
    public int n32PlateColor;
    public int n32Purpose;
    public int n32Type;
    public String strCapacity;
    public String strFuelConsumption;
    public String strHeight;
    public String strLength;
    public String strWeight;
    public String strWidth;

    public TruckInfo() {
        this.n32Type = -1;
        this.n32AxleNum = -1;
        this.n32Emission = -1;
        this.n32PlateColor = -1;
        this.n32Purpose = -1;
        this.strWeight = "";
        this.strCapacity = "";
        this.strLength = "";
        this.strWidth = "";
        this.strHeight = "";
        this.strFuelConsumption = "";
    }

    public TruckInfo(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4, String str5, String str6) {
        this.n32Type = i;
        this.n32AxleNum = i2;
        this.n32Emission = i3;
        this.n32PlateColor = i4;
        this.n32Purpose = i5;
        this.strWeight = str;
        this.strCapacity = str2;
        this.strLength = str3;
        this.strWidth = str4;
        this.strHeight = str5;
        this.strFuelConsumption = str6;
    }
}
