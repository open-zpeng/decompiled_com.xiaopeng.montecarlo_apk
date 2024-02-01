package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TeamMember implements Serializable {
    public TeamlocInfo locInfo;
    public long locationUpdateTime;
    public boolean online;
    public String uid;

    public TeamMember() {
        this.online = false;
        this.locationUpdateTime = 0L;
        this.uid = "";
        this.locInfo = new TeamlocInfo();
    }

    public TeamMember(boolean z, long j, String str, TeamlocInfo teamlocInfo) {
        this.online = z;
        this.locationUpdateTime = j;
        this.uid = str;
        this.locInfo = teamlocInfo;
    }
}
