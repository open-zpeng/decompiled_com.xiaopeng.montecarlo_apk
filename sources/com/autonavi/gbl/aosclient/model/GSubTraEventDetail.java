package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GSubTraEventDetail implements Serializable {
    public String address;
    public String audio;
    public int audiolen;
    public String avatar;
    public String createtime;
    public int criticism;
    public String desc;
    public String engBrief;
    public String eventname;
    public String expirytime;
    public double fLat;
    public double fLon;
    public String head;
    public String iconstyle;
    public String id;
    public String infoenddate;
    public String infostartdate;
    public String infotimeseg;
    public String labelDesc;
    public String lane;
    public String lastupdate;
    public int layer;
    public int layertag;
    public String nick;
    public int official;
    public String picurl;
    public int praise;
    public GTrifficSocolPicture socol_picture;
    public int source;
    public String title;

    public GSubTraEventDetail() {
        this.criticism = 0;
        this.layer = 0;
        this.id = "";
        this.lastupdate = "";
        this.infoenddate = "";
        this.title = "";
        this.source = 0;
        this.layertag = 0;
        this.nick = "";
        this.head = "";
        this.infotimeseg = "";
        this.audiolen = 0;
        this.address = "";
        this.desc = "";
        this.lane = "";
        this.infostartdate = "";
        this.official = 0;
        this.expirytime = "";
        this.picurl = "";
        this.praise = 0;
        this.audio = "";
        this.createtime = "";
        this.fLon = 0.0d;
        this.fLat = 0.0d;
        this.iconstyle = "";
        this.eventname = "";
        this.socol_picture = new GTrifficSocolPicture();
        this.engBrief = "";
        this.avatar = "";
        this.labelDesc = "";
    }

    public GSubTraEventDetail(int i, int i2, String str, String str2, String str3, String str4, int i3, int i4, String str5, String str6, String str7, int i5, String str8, String str9, String str10, String str11, int i6, String str12, String str13, int i7, String str14, String str15, double d, double d2, String str16, String str17, GTrifficSocolPicture gTrifficSocolPicture, String str18, String str19, String str20) {
        this.criticism = i;
        this.layer = i2;
        this.id = str;
        this.lastupdate = str2;
        this.infoenddate = str3;
        this.title = str4;
        this.source = i3;
        this.layertag = i4;
        this.nick = str5;
        this.head = str6;
        this.infotimeseg = str7;
        this.audiolen = i5;
        this.address = str8;
        this.desc = str9;
        this.lane = str10;
        this.infostartdate = str11;
        this.official = i6;
        this.expirytime = str12;
        this.picurl = str13;
        this.praise = i7;
        this.audio = str14;
        this.createtime = str15;
        this.fLon = d;
        this.fLat = d2;
        this.iconstyle = str16;
        this.eventname = str17;
        this.socol_picture = gTrifficSocolPicture;
        this.engBrief = str18;
        this.avatar = str19;
        this.labelDesc = str20;
    }
}
