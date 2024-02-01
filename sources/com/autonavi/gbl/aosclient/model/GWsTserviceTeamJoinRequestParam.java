package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamJoinRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String autodiv = "";
    public String dip = "";
    public String sessionid = "";
    public String teamNumber = "";
    public String uid = "";
    public GCoord2DDouble locInfo = new GCoord2DDouble();
    public long type = 1;
    public long timestamp = 0;

    public GWsTserviceTeamJoinRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMJOIN;
    }
}
