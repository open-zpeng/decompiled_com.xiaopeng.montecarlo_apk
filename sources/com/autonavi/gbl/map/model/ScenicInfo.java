package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ScenicInfo implements Serializable {
    public String aoiBusinessId;
    public byte hasFootPrint;
    public byte hasGuideMap;
    public byte hasGuideVoice;
    public byte hasRoute;
    public byte hasThermal;
    public byte hasWidget;
    public byte routeNum;

    public ScenicInfo() {
        this.aoiBusinessId = "";
        this.hasWidget = (byte) 0;
        this.hasGuideMap = (byte) 0;
        this.hasGuideVoice = (byte) 0;
        this.hasFootPrint = (byte) 0;
        this.hasThermal = (byte) 0;
        this.hasRoute = (byte) 0;
        this.routeNum = (byte) 0;
    }

    public ScenicInfo(String str, byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
        this.aoiBusinessId = str;
        this.hasWidget = b;
        this.hasGuideMap = b2;
        this.hasGuideVoice = b3;
        this.hasFootPrint = b4;
        this.hasThermal = b5;
        this.hasRoute = b6;
        this.routeNum = b7;
    }
}
