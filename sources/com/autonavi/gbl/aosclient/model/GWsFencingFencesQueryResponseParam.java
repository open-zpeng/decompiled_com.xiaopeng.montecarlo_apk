package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsFencingFencesQueryResponseParam extends BLResponseBase implements Serializable {
    public String errdetail = "";
    public WsFencingFencesQueryData data = new WsFencingFencesQueryData();

    public GWsFencingFencesQueryResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_FENCING_FENCES_QUERY_;
        this.mNetworkStatus = 0;
    }
}
