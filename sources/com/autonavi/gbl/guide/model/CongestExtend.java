package com.autonavi.gbl.guide.model;

import com.autonavi.gbl.guide.model.TmcSpotPicState;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CongestExtend implements Serializable {
    public String affect;
    public String cause;
    public String chatRoomId;
    public String congestExt;
    public String congestSpotPicUrl;
    public String congestionId;
    public String congestionSpotPicPath;
    public long eventId;
    public String ext;
    public long heavyTraffic;
    public int iconType;
    public String labels;
    public ArrayList<UserReportInfo> reportList;
    @TmcSpotPicState.TmcSpotPicState1
    public int spotTmcPicState;
    public String trend;

    public CongestExtend() {
        this.chatRoomId = "";
        this.cause = "";
        this.trend = "";
        this.affect = "";
        this.iconType = 0;
        this.ext = "";
        this.labels = "";
        this.congestExt = "";
        this.congestSpotPicUrl = "";
        this.spotTmcPicState = 0;
        this.congestionSpotPicPath = "";
        this.eventId = 0L;
        this.heavyTraffic = 0L;
        this.congestionId = "";
        this.reportList = new ArrayList<>();
    }

    public CongestExtend(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, @TmcSpotPicState.TmcSpotPicState1 int i2, String str9, long j, long j2, String str10, ArrayList<UserReportInfo> arrayList) {
        this.chatRoomId = str;
        this.cause = str2;
        this.trend = str3;
        this.affect = str4;
        this.iconType = i;
        this.ext = str5;
        this.labels = str6;
        this.congestExt = str7;
        this.congestSpotPicUrl = str8;
        this.spotTmcPicState = i2;
        this.congestionSpotPicPath = str9;
        this.eventId = j;
        this.heavyTraffic = j2;
        this.congestionId = str10;
        this.reportList = arrayList;
    }
}
