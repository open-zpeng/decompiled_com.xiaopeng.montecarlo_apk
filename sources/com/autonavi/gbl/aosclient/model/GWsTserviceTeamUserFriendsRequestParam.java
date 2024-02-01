package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceTeamUserFriendsRequestParam extends BLRequestBase implements Serializable {
    public String div = "";
    public String autodiv = "";
    public String dip = "";
    public String sessionid = "";
    public String uid = "";
    public long timestamp = 0;

    public GWsTserviceTeamUserFriendsRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMUSERFRIENDS;
    }
}
