package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTserviceTeamResponseParam implements Serializable {
    public String memberStamp;
    public ArrayList<GWsTserviceTeamResponseMember> members;
    public long supNum;
    public GWsTserviceTeamResponseTeam team;
    public String teamStamp;

    public GWsTserviceTeamResponseParam() {
        this.team = new GWsTserviceTeamResponseTeam();
        this.members = new ArrayList<>();
        this.teamStamp = "";
        this.memberStamp = "";
        this.supNum = 0L;
    }

    public GWsTserviceTeamResponseParam(GWsTserviceTeamResponseTeam gWsTserviceTeamResponseTeam, ArrayList<GWsTserviceTeamResponseMember> arrayList, String str, String str2, long j) {
        this.team = gWsTserviceTeamResponseTeam;
        this.members = arrayList;
        this.teamStamp = str;
        this.memberStamp = str2;
        this.supNum = j;
    }
}
