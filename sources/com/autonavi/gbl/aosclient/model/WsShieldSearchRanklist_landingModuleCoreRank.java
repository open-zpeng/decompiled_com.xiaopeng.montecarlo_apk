package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklist_landingModuleCoreRank implements Serializable {
    public String id;
    public ArrayList<WsShieldSearchRanklist_landingCoreRankList> list;
    public String title;

    public WsShieldSearchRanklist_landingModuleCoreRank() {
        this.id = "";
        this.title = "";
        this.list = new ArrayList<>();
    }

    public WsShieldSearchRanklist_landingModuleCoreRank(String str, String str2, ArrayList<WsShieldSearchRanklist_landingCoreRankList> arrayList) {
        this.id = str;
        this.title = str2;
        this.list = arrayList;
    }
}
