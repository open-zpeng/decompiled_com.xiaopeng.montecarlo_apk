package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataJamBubblesPostBack implements Serializable {
    public long arriveTime;
    public String congestionId;
    public String cordLinkId;
    public String detailType;
    public int eta;
    public int length;
    public ArrayList<String> linkIds;
    public String roadName;
    public String trendDesc;
    public int trendEndTime;
    public int trendStartTime;
    public int trendType;

    public WsNavigationDynamicDataJamBubblesPostBack() {
        this.arriveTime = 0L;
        this.congestionId = "";
        this.cordLinkId = "";
        this.detailType = "";
        this.eta = 0;
        this.length = 0;
        this.linkIds = new ArrayList<>();
        this.roadName = "";
        this.trendDesc = "";
        this.trendEndTime = 0;
        this.trendStartTime = 0;
        this.trendType = 0;
    }

    public WsNavigationDynamicDataJamBubblesPostBack(long j, String str, String str2, String str3, int i, int i2, ArrayList<String> arrayList, String str4, String str5, int i3, int i4, int i5) {
        this.arriveTime = j;
        this.congestionId = str;
        this.cordLinkId = str2;
        this.detailType = str3;
        this.eta = i;
        this.length = i2;
        this.linkIds = arrayList;
        this.roadName = str4;
        this.trendDesc = str5;
        this.trendEndTime = i3;
        this.trendStartTime = i4;
        this.trendType = i5;
    }
}
