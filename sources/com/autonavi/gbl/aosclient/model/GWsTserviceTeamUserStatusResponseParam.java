package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamUserStatusResponseParam extends BLResponseBase implements Serializable {
    public String teamId = "";
    public String teamNumber = "";

    public GWsTserviceTeamUserStatusResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMUSERSTATUS;
    }
}
