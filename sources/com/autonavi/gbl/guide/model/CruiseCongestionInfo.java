package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.common.path.model.TrafficStatus;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CruiseCongestionInfo implements Serializable {
    public int congestionEventId;
    @TrafficStatus.TrafficStatus1
    public int congestionStatus;
    public String congestionlabels;
    public int etaTime;
    public int eventID;
    public int length;
    public String roadName;
    public ArrayList<LinkLineStatus> vecLinkData;

    public CruiseCongestionInfo() {
        this.roadName = "";
        this.congestionStatus = 0;
        this.etaTime = 0;
        this.length = 0;
        this.vecLinkData = new ArrayList<>();
        this.congestionlabels = "";
        this.congestionEventId = 0;
        this.eventID = 0;
    }

    public CruiseCongestionInfo(String str, @TrafficStatus.TrafficStatus1 int i, int i2, int i3, ArrayList<LinkLineStatus> arrayList, String str2, int i4, int i5) {
        this.roadName = str;
        this.congestionStatus = i;
        this.etaTime = i2;
        this.length = i3;
        this.vecLinkData = arrayList;
        this.congestionlabels = str2;
        this.congestionEventId = i4;
        this.eventID = i5;
    }
}
