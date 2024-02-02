package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamResponseMember implements Serializable {
    public String imgUrl;
    public long joinTime;
    public GCoord2DDouble locInfo;
    public long locationUpdateTime;
    public String nickName;
    public boolean online;
    public String source;
    public String tnn;
    public String uid;

    public GWsTserviceTeamResponseMember() {
        this.uid = "";
        this.imgUrl = "";
        this.nickName = "";
        this.tnn = "";
        this.source = "";
        this.locInfo = new GCoord2DDouble();
        this.locationUpdateTime = 0L;
        this.joinTime = 0L;
        this.online = false;
    }

    public GWsTserviceTeamResponseMember(String str, String str2, String str3, String str4, String str5, GCoord2DDouble gCoord2DDouble, long j, long j2, boolean z) {
        this.uid = str;
        this.imgUrl = str2;
        this.nickName = str3;
        this.tnn = str4;
        this.source = str5;
        this.locInfo = gCoord2DDouble;
        this.locationUpdateTime = j;
        this.joinTime = j2;
        this.online = z;
    }
}
