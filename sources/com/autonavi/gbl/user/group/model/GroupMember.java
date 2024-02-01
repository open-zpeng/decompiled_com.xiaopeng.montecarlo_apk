package com.autonavi.gbl.user.group.model;

import com.autonavi.gbl.common.model.Coord2DDouble;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupMember implements Serializable {
    public String imgUrl;
    public long joinTime;
    public Coord2DDouble locInfo;
    public long locUpdateTime;
    public String nickName;
    public boolean online;
    public String source;
    public String teamNick;
    public String uid;

    public GroupMember() {
        this.uid = "";
        this.imgUrl = "";
        this.nickName = "";
        this.teamNick = "";
        this.source = "";
        this.locInfo = new Coord2DDouble();
        this.locUpdateTime = 0L;
        this.joinTime = 0L;
        this.online = false;
    }

    public GroupMember(String str, String str2, String str3, String str4, String str5, Coord2DDouble coord2DDouble, long j, long j2, boolean z) {
        this.uid = str;
        this.imgUrl = str2;
        this.nickName = str3;
        this.teamNick = str4;
        this.source = str5;
        this.locInfo = coord2DDouble;
        this.locUpdateTime = j;
        this.joinTime = j2;
        this.online = z;
    }
}
