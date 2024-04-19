package com.autonavi.gbl.user.behavior.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ConfigSetting implements Serializable {
    public int n32AdasLaneDeviation;
    public int n32AdasVehicleCollision;
    public int n32AdasVehicleStart;
    public int n32Animation;
    public int n32AudioMixMode;
    public int n32AvoidLimit;
    public int n32AvoidLoad;
    public int n32BroadcastMode;
    public int n32BroadcastVolume;
    public int n32CarID;
    public int n32CarType;
    public int n32DayNightMode;
    public int n32DriveWarn;
    public int n32Emission;
    public int n32InputMethod;
    public int n32MapColor;
    public int n32MapviewMode;
    public int n32Mute;
    public int n32MyFavorite;
    public int n32PlateColor;
    public int n32PowerType;
    public int n32Purpose;
    public int n32RealTrafficShare;
    public int n32RoadEvent;
    public int n32RoadWarn;
    public int n32SafeBroadcast;
    public int n32SystemBar;
    public int n32TruckAxleNum;
    public int n32VoiceWakeUp;
    public String[] strBroadcastVoice;
    public String strFuelConsumption;
    public String strPlanPref;
    public String strPlateNumber;
    public String strSearchPref;
    public String strTruckCapacity;
    public String strTruckHeight;
    public String strTruckLength;
    public String strTruckPlanPref;
    public String strTruckWeight;
    public String strTruckWidth;

    public ConfigSetting() {
        this.n32MapviewMode = 0;
        this.n32RoadEvent = 1;
        this.n32MyFavorite = 1;
        this.n32CarID = 0;
        this.strPlanPref = "";
        this.n32AvoidLimit = 0;
        this.strPlateNumber = "";
        this.n32CarType = -1;
        this.n32PowerType = -1;
        this.strTruckWeight = "";
        this.strTruckCapacity = "";
        this.strTruckLength = "";
        this.strTruckWidth = "";
        this.strTruckHeight = "";
        this.n32TruckAxleNum = 0;
        this.n32AvoidLoad = 0;
        this.n32Emission = -1;
        this.n32PlateColor = -1;
        this.n32Purpose = -1;
        this.strFuelConsumption = "";
        this.strTruckPlanPref = "";
        this.n32BroadcastMode = 0;
        this.strSearchPref = "";
        this.n32DayNightMode = 0;
        this.n32SafeBroadcast = 0;
        this.n32RoadWarn = 0;
        this.n32DriveWarn = 0;
        this.n32BroadcastVolume = 0;
        this.n32AudioMixMode = 0;
        this.n32MapColor = 0;
        this.n32InputMethod = 0;
        this.n32SystemBar = 0;
        this.n32VoiceWakeUp = 0;
        this.n32Animation = 0;
        this.n32Mute = 0;
        this.n32AdasLaneDeviation = 1;
        this.n32AdasVehicleStart = 1;
        this.n32AdasVehicleCollision = 1;
        this.n32RealTrafficShare = 0;
        this.strBroadcastVoice = new String[3];
    }

    public ConfigSetting(int i, int i2, int i3, int i4, String str, int i5, String str2, int i6, int i7, String str3, String str4, String str5, String str6, String str7, int i8, int i9, int i10, int i11, int i12, String str8, String str9, int i13, String str10, int i14, int i15, int i16, int i17, int i18, String[] strArr, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29) {
        this.n32MapviewMode = i;
        this.n32RoadEvent = i2;
        this.n32MyFavorite = i3;
        this.n32CarID = i4;
        this.strPlanPref = str;
        this.n32AvoidLimit = i5;
        this.strPlateNumber = str2;
        this.n32CarType = i6;
        this.n32PowerType = i7;
        this.strTruckWeight = str3;
        this.strTruckCapacity = str4;
        this.strTruckLength = str5;
        this.strTruckWidth = str6;
        this.strTruckHeight = str7;
        this.n32TruckAxleNum = i8;
        this.n32AvoidLoad = i9;
        this.n32Emission = i10;
        this.n32PlateColor = i11;
        this.n32Purpose = i12;
        this.strFuelConsumption = str8;
        this.strTruckPlanPref = str9;
        this.n32BroadcastMode = i13;
        this.strSearchPref = str10;
        this.n32DayNightMode = i14;
        this.n32SafeBroadcast = i15;
        this.n32RoadWarn = i16;
        this.n32DriveWarn = i17;
        this.n32BroadcastVolume = i18;
        this.strBroadcastVoice = strArr;
        this.n32AudioMixMode = i19;
        this.n32MapColor = i20;
        this.n32InputMethod = i21;
        this.n32SystemBar = i22;
        this.n32VoiceWakeUp = i23;
        this.n32Animation = i24;
        this.n32Mute = i25;
        this.n32AdasLaneDeviation = i26;
        this.n32AdasVehicleStart = i27;
        this.n32AdasVehicleCollision = i28;
        this.n32RealTrafficShare = i29;
    }
}
