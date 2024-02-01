package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamJoinResponseParam extends BLResponseBase implements Serializable {
    public GWsTserviceTeamResponseParam data = new GWsTserviceTeamResponseParam();

    public GWsTserviceTeamJoinResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMJOIN;
    }
}
