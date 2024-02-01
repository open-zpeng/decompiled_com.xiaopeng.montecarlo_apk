package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsNavigationDynamicDataJamBubblesDataSegment implements Serializable {
    public WsNavigationDynamicDataJamBubblesSegmentDeepInfo cost;
    public WsNavigationDynamicDataJamBubblesSegmentData data;
    public WsNavigationDynamicDataJamBubblesSegmentDeepInfo deepInfo;
    public WsNavigationDynamicDataJamBubblesSegmentDeepInfo degree;
    public WsNavigationDynamicDataJamBubblesDataTopLeft display;
    public int jumpType;
    public WsNavigationDynamicDataJamBubblesLinkSegment linkSegment;
    public String pic;
    public WsNavigationDynamicDataJamBubblesPostBack postback;
    public int showType;
    public WsNavigationDynamicDataJamBubblesSegmentDeepInfo trend;

    public WsNavigationDynamicDataJamBubblesDataSegment() {
        this.deepInfo = new WsNavigationDynamicDataJamBubblesSegmentDeepInfo();
        this.trend = new WsNavigationDynamicDataJamBubblesSegmentDeepInfo();
        this.cost = new WsNavigationDynamicDataJamBubblesSegmentDeepInfo();
        this.degree = new WsNavigationDynamicDataJamBubblesSegmentDeepInfo();
        this.linkSegment = new WsNavigationDynamicDataJamBubblesLinkSegment();
        this.data = new WsNavigationDynamicDataJamBubblesSegmentData();
        this.pic = "";
        this.display = new WsNavigationDynamicDataJamBubblesDataTopLeft();
        this.jumpType = 0;
        this.showType = 0;
        this.postback = new WsNavigationDynamicDataJamBubblesPostBack();
    }

    public WsNavigationDynamicDataJamBubblesDataSegment(WsNavigationDynamicDataJamBubblesSegmentDeepInfo wsNavigationDynamicDataJamBubblesSegmentDeepInfo, WsNavigationDynamicDataJamBubblesSegmentDeepInfo wsNavigationDynamicDataJamBubblesSegmentDeepInfo2, WsNavigationDynamicDataJamBubblesSegmentDeepInfo wsNavigationDynamicDataJamBubblesSegmentDeepInfo3, WsNavigationDynamicDataJamBubblesSegmentDeepInfo wsNavigationDynamicDataJamBubblesSegmentDeepInfo4, WsNavigationDynamicDataJamBubblesLinkSegment wsNavigationDynamicDataJamBubblesLinkSegment, WsNavigationDynamicDataJamBubblesSegmentData wsNavigationDynamicDataJamBubblesSegmentData, String str, WsNavigationDynamicDataJamBubblesDataTopLeft wsNavigationDynamicDataJamBubblesDataTopLeft, int i, int i2, WsNavigationDynamicDataJamBubblesPostBack wsNavigationDynamicDataJamBubblesPostBack) {
        this.deepInfo = wsNavigationDynamicDataJamBubblesSegmentDeepInfo;
        this.trend = wsNavigationDynamicDataJamBubblesSegmentDeepInfo2;
        this.cost = wsNavigationDynamicDataJamBubblesSegmentDeepInfo3;
        this.degree = wsNavigationDynamicDataJamBubblesSegmentDeepInfo4;
        this.linkSegment = wsNavigationDynamicDataJamBubblesLinkSegment;
        this.data = wsNavigationDynamicDataJamBubblesSegmentData;
        this.pic = str;
        this.display = wsNavigationDynamicDataJamBubblesDataTopLeft;
        this.jumpType = i;
        this.showType = i2;
        this.postback = wsNavigationDynamicDataJamBubblesPostBack;
    }
}
