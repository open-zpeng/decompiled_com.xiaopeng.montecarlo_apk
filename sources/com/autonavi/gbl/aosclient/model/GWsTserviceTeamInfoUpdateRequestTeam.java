package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamInfoUpdateRequestTeam implements Serializable {
    public String announcement;
    public GWsTserviceTeamInfoUpdateRequestDesination destination;
    public long teamDismissTime;
    public String teamName;

    public GWsTserviceTeamInfoUpdateRequestTeam() {
        this.destination = new GWsTserviceTeamInfoUpdateRequestDesination();
        this.teamDismissTime = 0L;
        this.teamName = "";
        this.announcement = "";
    }

    public GWsTserviceTeamInfoUpdateRequestTeam(GWsTserviceTeamInfoUpdateRequestDesination gWsTserviceTeamInfoUpdateRequestDesination, long j, String str, String str2) {
        this.destination = gWsTserviceTeamInfoUpdateRequestDesination;
        this.teamDismissTime = j;
        this.teamName = str;
        this.announcement = str2;
    }
}
