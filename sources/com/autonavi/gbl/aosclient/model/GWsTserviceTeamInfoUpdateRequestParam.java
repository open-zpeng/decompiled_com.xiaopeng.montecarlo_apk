package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamInfoUpdateRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String autodiv = "";
    public String dip = "";
    public String sessionid = "";
    public String teamId = "";
    public String uid = "";
    public GWsTserviceTeamInfoUpdateRequestTeam team = new GWsTserviceTeamInfoUpdateRequestTeam();
    public long timestamp = 0;

    public GWsTserviceTeamInfoUpdateRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMINFOUPDATE;
    }
}
