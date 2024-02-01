package com.autonavi.gbl.user.group.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GroupBaseInfo implements Serializable {
    public GroupAnnouncement announcement;
    public String chatId;
    public long createdTime;
    public GroupDestination destination;
    public long dissloveTime;
    public long lastUpdate;
    public String leaderId;
    public String teamId;
    public String teamName;
    public String teamNumber;

    public GroupBaseInfo() {
        this.teamId = "";
        this.chatId = "";
        this.teamName = "";
        this.teamNumber = "";
        this.leaderId = "";
        this.dissloveTime = 0L;
        this.createdTime = 0L;
        this.lastUpdate = 0L;
        this.destination = new GroupDestination();
        this.announcement = new GroupAnnouncement();
    }

    public GroupBaseInfo(String str, String str2, String str3, String str4, String str5, long j, long j2, long j3, GroupDestination groupDestination, GroupAnnouncement groupAnnouncement) {
        this.teamId = str;
        this.chatId = str2;
        this.teamName = str3;
        this.teamNumber = str4;
        this.leaderId = str5;
        this.dissloveTime = j;
        this.createdTime = j2;
        this.lastUpdate = j3;
        this.destination = groupDestination;
        this.announcement = groupAnnouncement;
    }
}
