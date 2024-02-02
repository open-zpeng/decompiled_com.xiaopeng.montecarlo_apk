package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamResponseTeam implements Serializable {
    public GWsTserviceTeamResponseAnnouncement announcement;
    public String artcChannelId;
    public String cid;
    public GWsTserviceTeamResponseDestination destination;
    public long lastUpdate;
    public String leader;
    public long teamCreatedTime;
    public long teamDismissTime;
    public String teamId;
    public String teamName;
    public String teamNumber;

    public GWsTserviceTeamResponseTeam() {
        this.teamId = "";
        this.cid = "";
        this.teamName = "";
        this.teamNumber = "";
        this.leader = "";
        this.teamDismissTime = 0L;
        this.teamCreatedTime = 0L;
        this.lastUpdate = 0L;
        this.destination = new GWsTserviceTeamResponseDestination();
        this.announcement = new GWsTserviceTeamResponseAnnouncement();
        this.artcChannelId = "";
    }

    public GWsTserviceTeamResponseTeam(String str, String str2, String str3, String str4, String str5, long j, long j2, long j3, GWsTserviceTeamResponseDestination gWsTserviceTeamResponseDestination, GWsTserviceTeamResponseAnnouncement gWsTserviceTeamResponseAnnouncement, String str6) {
        this.teamId = str;
        this.cid = str2;
        this.teamName = str3;
        this.teamNumber = str4;
        this.leader = str5;
        this.teamDismissTime = j;
        this.teamCreatedTime = j2;
        this.lastUpdate = j3;
        this.destination = gWsTserviceTeamResponseDestination;
        this.announcement = gWsTserviceTeamResponseAnnouncement;
        this.artcChannelId = str6;
    }
}
