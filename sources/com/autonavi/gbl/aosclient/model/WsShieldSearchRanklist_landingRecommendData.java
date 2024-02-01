package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingRecommendData implements Serializable {
    public WsShieldSearchRanklist_landingDataData data;
    public WsShieldSearchRanklist_landingDataLayout layout;
    public ArrayList<String> log;

    public WsShieldSearchRanklist_landingRecommendData() {
        this.layout = new WsShieldSearchRanklist_landingDataLayout();
        this.log = new ArrayList<>();
        this.data = new WsShieldSearchRanklist_landingDataData();
    }

    public WsShieldSearchRanklist_landingRecommendData(WsShieldSearchRanklist_landingDataLayout wsShieldSearchRanklist_landingDataLayout, ArrayList<String> arrayList, WsShieldSearchRanklist_landingDataData wsShieldSearchRanklist_landingDataData) {
        this.layout = wsShieldSearchRanklist_landingDataLayout;
        this.log = arrayList;
        this.data = wsShieldSearchRanklist_landingDataData;
    }
}
