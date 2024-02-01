package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamInfoGetRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String autodiv = "";
    public String dip = "";
    public String sessionid = "";
    public String teamId = "";
    public String uid = "";
    public long timestamp = 0;

    public GWsTserviceTeamInfoGetRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMINFOGET;
    }
}
