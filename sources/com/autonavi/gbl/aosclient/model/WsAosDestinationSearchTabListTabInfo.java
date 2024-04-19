package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAosDestinationSearchTabListTabInfo implements Serializable {
    public String aoiId;
    public String childType;
    public String fullName;
    public String name;
    public String parentPoiId;
    public String poiId;
    public String typeCode;
    public String x;
    public String y;

    public WsAosDestinationSearchTabListTabInfo() {
        this.aoiId = "";
        this.childType = "";
        this.fullName = "";
        this.name = "";
        this.parentPoiId = "";
        this.poiId = "";
        this.typeCode = "";
        this.x = "";
        this.y = "";
    }

    public WsAosDestinationSearchTabListTabInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.aoiId = str;
        this.childType = str2;
        this.fullName = str3;
        this.name = str4;
        this.parentPoiId = str5;
        this.poiId = str6;
        this.typeCode = str7;
        this.x = str8;
        this.y = str9;
    }
}
