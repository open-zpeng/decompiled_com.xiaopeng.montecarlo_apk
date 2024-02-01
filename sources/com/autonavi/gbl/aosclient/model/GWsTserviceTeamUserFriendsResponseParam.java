package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTserviceTeamUserFriendsResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<GWsTserviceTeamUserFriendsResponseFriend> friends = new ArrayList<>();

    public GWsTserviceTeamUserFriendsResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WSTSERVICETEAMUSERFRIENDS;
    }
}
