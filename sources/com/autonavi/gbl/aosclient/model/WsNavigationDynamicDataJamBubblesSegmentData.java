package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataJamBubblesSegmentData implements Serializable {
    public WsNavigationDynamicDataJamBubblesDataTopLeft bottomRight;
    public String congestionId;
    public long eventId;
    public String roadName;
    public WsNavigationDynamicDataJamBubblesDataTopLeft topLeft;
    public int trendCode;
    public int trendEtaMatch;

    public WsNavigationDynamicDataJamBubblesSegmentData() {
        this.congestionId = "";
        this.eventId = 0L;
        this.topLeft = new WsNavigationDynamicDataJamBubblesDataTopLeft();
        this.bottomRight = new WsNavigationDynamicDataJamBubblesDataTopLeft();
        this.roadName = "";
        this.trendCode = 0;
        this.trendEtaMatch = 0;
    }

    public WsNavigationDynamicDataJamBubblesSegmentData(String str, long j, WsNavigationDynamicDataJamBubblesDataTopLeft wsNavigationDynamicDataJamBubblesDataTopLeft, WsNavigationDynamicDataJamBubblesDataTopLeft wsNavigationDynamicDataJamBubblesDataTopLeft2, String str2, int i, int i2) {
        this.congestionId = str;
        this.eventId = j;
        this.topLeft = wsNavigationDynamicDataJamBubblesDataTopLeft;
        this.bottomRight = wsNavigationDynamicDataJamBubblesDataTopLeft2;
        this.roadName = str2;
        this.trendCode = i;
        this.trendEtaMatch = i2;
    }
}
