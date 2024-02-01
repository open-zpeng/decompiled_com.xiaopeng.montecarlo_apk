package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class WsShieldSearchRanklistPortalMetaLog implements Serializable {
    public String List_Page_ID;
    public String List_Pathid;
    public String gsid;
    public String list_id;
    public String testid;

    public WsShieldSearchRanklistPortalMetaLog() {
        this.testid = "";
        this.gsid = "";
        this.List_Pathid = "";
        this.List_Page_ID = "";
        this.list_id = "";
    }

    public WsShieldSearchRanklistPortalMetaLog(String str, String str2, String str3, String str4, String str5) {
        this.testid = str;
        this.gsid = str2;
        this.List_Pathid = str3;
        this.List_Page_ID = str4;
        this.list_id = str5;
    }
}
