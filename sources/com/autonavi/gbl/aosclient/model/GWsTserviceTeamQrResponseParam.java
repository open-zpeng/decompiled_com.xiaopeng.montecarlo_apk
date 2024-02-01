package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamQrResponseParam extends BLResponseBase implements Serializable {
    public String data = "";

    public GWsTserviceTeamQrResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMQR;
    }
}
