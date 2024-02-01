package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsFencingGroupsQueryResponseParam extends BLResponseBase implements Serializable {
    public String errdetail = "";
    public WsFencingGroupsQueryData data = new WsFencingGroupsQueryData();

    public GWsFencingGroupsQueryResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_FENCING_GROUPS_QUERY_;
        this.mNetworkStatus = 0;
    }
}
