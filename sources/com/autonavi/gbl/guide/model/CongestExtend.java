package com.autonavi.gbl.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CongestExtend implements Serializable {
    public String affect;
    public String cause;
    public String chatRoomId;
    public ArrayList<UserReportInfo> reportList;
    public String trend;

    public CongestExtend() {
        this.chatRoomId = "";
        this.cause = "";
        this.trend = "";
        this.affect = "";
        this.reportList = new ArrayList<>();
    }

    public CongestExtend(String str, String str2, String str3, String str4, ArrayList<UserReportInfo> arrayList) {
        this.chatRoomId = str;
        this.cause = str2;
        this.trend = str3;
        this.affect = str4;
        this.reportList = arrayList;
    }
}
