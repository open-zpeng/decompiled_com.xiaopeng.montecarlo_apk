package com.autonavi.gbl.user.msgpush.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TeamInfo implements Serializable {
    public String artcChannelId;
    public TeamDestinationInfo destination;
    public String invite;
    public String leader;
    public String teamId;
    public String teamName;
    public String teamNumber;
    public String type;

    public TeamInfo() {
        this.type = "";
        this.leader = "";
        this.teamName = "";
        this.teamNumber = "";
        this.teamId = "";
        this.invite = "";
        this.artcChannelId = "";
        this.destination = new TeamDestinationInfo();
    }

    public TeamInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, TeamDestinationInfo teamDestinationInfo) {
        this.type = str;
        this.leader = str2;
        this.teamName = str3;
        this.teamNumber = str4;
        this.teamId = str5;
        this.invite = str6;
        this.artcChannelId = str7;
        this.destination = teamDestinationInfo;
    }
}
