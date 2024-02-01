package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamKickResponseParam extends BLResponseBase implements Serializable {
    public GWsTserviceTeamResponseParam data = new GWsTserviceTeamResponseParam();

    public GWsTserviceTeamKickResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMKICK;
    }
}
