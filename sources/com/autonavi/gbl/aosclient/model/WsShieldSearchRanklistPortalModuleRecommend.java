package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalModuleRecommend implements Serializable {
    public ArrayList<WsShieldSearchRanklistPortalRecommendData> data;

    public WsShieldSearchRanklistPortalModuleRecommend() {
        this.data = new ArrayList<>();
    }

    public WsShieldSearchRanklistPortalModuleRecommend(ArrayList<WsShieldSearchRanklistPortalRecommendData> arrayList) {
        this.data = arrayList;
    }
}
