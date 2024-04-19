package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalModuleCoreRank implements Serializable {
    public String id;
    public ArrayList<WsShieldSearchRanklistPortalCoreRankList> list;
    public String title;

    public WsShieldSearchRanklistPortalModuleCoreRank() {
        this.id = "";
        this.title = "";
        this.list = new ArrayList<>();
    }

    public WsShieldSearchRanklistPortalModuleCoreRank(String str, String str2, ArrayList<WsShieldSearchRanklistPortalCoreRankList> arrayList) {
        this.id = str;
        this.title = str2;
        this.list = arrayList;
    }
}
