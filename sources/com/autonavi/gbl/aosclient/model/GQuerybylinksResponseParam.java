package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GQuerybylinksResponseParam extends BLResponseBase implements Serializable {
    public int status = 0;
    public QueryByLinksAckData data = new QueryByLinksAckData();

    public GQuerybylinksResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_TRAFFIC_DYNAMICINFO_QUERYBYLINKS;
        this.mNetworkStatus = 0;
    }
}
