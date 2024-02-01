package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingModuleRecommend implements Serializable {
    public ArrayList<WsShieldSearchRanklist_landingRecommendData> data;

    public WsShieldSearchRanklist_landingModuleRecommend() {
        this.data = new ArrayList<>();
    }

    public WsShieldSearchRanklist_landingModuleRecommend(ArrayList<WsShieldSearchRanklist_landingRecommendData> arrayList) {
        this.data = arrayList;
    }
}
