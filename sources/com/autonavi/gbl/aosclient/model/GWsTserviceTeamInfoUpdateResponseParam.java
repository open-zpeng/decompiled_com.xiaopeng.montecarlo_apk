package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamInfoUpdateResponseParam extends BLResponseBase implements Serializable {
    public GWsTserviceTeamResponseTeam team = new GWsTserviceTeamResponseTeam();
    public String teamStamp = "";
    public String memberStamp = "";

    public GWsTserviceTeamInfoUpdateResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMINFOUPDATE;
    }
}
