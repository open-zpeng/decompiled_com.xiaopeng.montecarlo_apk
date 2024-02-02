package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsAudiHcp3EventSearchUgcEventItem implements Serializable {
    public String brief;
    public String engBrief;
    public String eventDesc;
    public int eventID;
    public int eventType;
    public String geoAddress;
    public WsAudiHcp3EventSearchGeoCoord geoCoord;
    public String picture;
    public int reliability;
    public int source;
    public WsAudiHcp3EventSearchTimePeriod timePeriod;
    public long updateTime;

    public WsAudiHcp3EventSearchUgcEventItem() {
        this.eventID = 0;
        this.updateTime = 0L;
        this.source = 0;
        this.eventType = 0;
        this.reliability = 0;
        this.brief = "";
        this.engBrief = "";
        this.eventDesc = "";
        this.geoAddress = "";
        this.picture = "";
        this.timePeriod = new WsAudiHcp3EventSearchTimePeriod();
        this.geoCoord = new WsAudiHcp3EventSearchGeoCoord();
    }

    public WsAudiHcp3EventSearchUgcEventItem(int i, long j, int i2, int i3, int i4, String str, String str2, String str3, String str4, String str5, WsAudiHcp3EventSearchTimePeriod wsAudiHcp3EventSearchTimePeriod, WsAudiHcp3EventSearchGeoCoord wsAudiHcp3EventSearchGeoCoord) {
        this.eventID = i;
        this.updateTime = j;
        this.source = i2;
        this.eventType = i3;
        this.reliability = i4;
        this.brief = str;
        this.engBrief = str2;
        this.eventDesc = str3;
        this.geoAddress = str4;
        this.picture = str5;
        this.timePeriod = wsAudiHcp3EventSearchTimePeriod;
        this.geoCoord = wsAudiHcp3EventSearchGeoCoord;
    }
}
