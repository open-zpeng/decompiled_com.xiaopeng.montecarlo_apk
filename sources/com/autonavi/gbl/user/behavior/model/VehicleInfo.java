package com.autonavi.gbl.user.behavior.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Serializable {
    public int n32CheckReminder;
    public int n32LimitReminder;
    public int n32PowerType;
    public int n32TruckAvoidLoad;
    public int n32Type;
    public int n32ViolationReminder;
    public TruckInfo stTruckInfo;
    public String strCode;
    public String strEngineNum;
    public String strFrameNum;
    public String strLogoUrl;
    public String strMsg;
    public String strPlateNum;
    public String strTelphone;
    public String strValidPeriod;

    public VehicleInfo() {
        this.strPlateNum = "";
        this.n32Type = 0;
        this.n32PowerType = -1;
        this.strMsg = "";
        this.strCode = "";
        this.strLogoUrl = "";
        this.stTruckInfo = new TruckInfo();
        this.strFrameNum = "";
        this.strEngineNum = "";
        this.strTelphone = "";
        this.n32ViolationReminder = 0;
        this.strValidPeriod = "";
        this.n32CheckReminder = 0;
        this.n32LimitReminder = 0;
        this.n32TruckAvoidLoad = 0;
    }

    public VehicleInfo(String str, int i, int i2, String str2, String str3, String str4, TruckInfo truckInfo, String str5, String str6, String str7, int i3, String str8, int i4, int i5, int i6) {
        this.strPlateNum = str;
        this.n32Type = i;
        this.n32PowerType = i2;
        this.strMsg = str2;
        this.strCode = str3;
        this.strLogoUrl = str4;
        this.stTruckInfo = truckInfo;
        this.strFrameNum = str5;
        this.strEngineNum = str6;
        this.strTelphone = str7;
        this.n32ViolationReminder = i3;
        this.strValidPeriod = str8;
        this.n32CheckReminder = i4;
        this.n32LimitReminder = i5;
        this.n32TruckAvoidLoad = i6;
    }
}
