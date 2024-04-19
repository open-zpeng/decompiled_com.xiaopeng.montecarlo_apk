package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalRecommendData implements Serializable {
    public WsShieldSearchRanklistPortalDataData data;
    public WsShieldSearchRanklistPortalDataLayout layout;
    public ArrayList<String> log;

    public WsShieldSearchRanklistPortalRecommendData() {
        this.layout = new WsShieldSearchRanklistPortalDataLayout();
        this.log = new ArrayList<>();
        this.data = new WsShieldSearchRanklistPortalDataData();
    }

    public WsShieldSearchRanklistPortalRecommendData(WsShieldSearchRanklistPortalDataLayout wsShieldSearchRanklistPortalDataLayout, ArrayList<String> arrayList, WsShieldSearchRanklistPortalDataData wsShieldSearchRanklistPortalDataData) {
        this.layout = wsShieldSearchRanklistPortalDataLayout;
        this.log = arrayList;
        this.data = wsShieldSearchRanklistPortalDataData;
    }
}
