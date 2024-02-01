package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamCreateRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String autodiv = "";
    public String dip = "";
    public String sessionid = "";
    public String uid = "";
    public GCoord2DDouble locInfo = new GCoord2DDouble();
    public long timestamp = 0;
    public boolean isNotDissolve = false;
    public GWsTserviceTeamCreateDestination destination = new GWsTserviceTeamCreateDestination();

    public GWsTserviceTeamCreateRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMCREATE;
    }
}
