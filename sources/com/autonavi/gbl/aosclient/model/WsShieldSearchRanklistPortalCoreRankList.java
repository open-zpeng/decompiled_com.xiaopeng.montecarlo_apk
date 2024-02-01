package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalCoreRankList implements Serializable {
    public String business_args;
    public String id;
    public ArrayList<String> logs;
    public String schema;
    public String src;
    public String sub_title;
    public String title;
    public String title_url;

    public WsShieldSearchRanklistPortalCoreRankList() {
        this.id = "";
        this.src = "";
        this.title = "";
        this.title_url = "";
        this.sub_title = "";
        this.logs = new ArrayList<>();
        this.schema = "";
        this.business_args = "";
    }

    public WsShieldSearchRanklistPortalCoreRankList(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7) {
        this.id = str;
        this.src = str2;
        this.title = str3;
        this.title_url = str4;
        this.sub_title = str5;
        this.logs = arrayList;
        this.schema = str6;
        this.business_args = str7;
    }
}
