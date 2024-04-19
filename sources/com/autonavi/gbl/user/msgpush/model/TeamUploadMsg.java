package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TeamUploadMsg implements Serializable {
    public String channel;
    public double lat;
    public double lon;
    public String memberStamp;
    public String teamStamp;
    public String teamid;
    public String uid;

    public TeamUploadMsg() {
        this.lon = 0.0d;
        this.lat = 0.0d;
        this.uid = "";
        this.channel = "";
        this.teamid = "";
        this.teamStamp = "";
        this.memberStamp = "";
    }

    public TeamUploadMsg(double d, double d2, String str, String str2, String str3, String str4, String str5) {
        this.lon = d;
        this.lat = d2;
        this.uid = str;
        this.channel = str2;
        this.teamid = str3;
        this.teamStamp = str4;
        this.memberStamp = str5;
    }
}
