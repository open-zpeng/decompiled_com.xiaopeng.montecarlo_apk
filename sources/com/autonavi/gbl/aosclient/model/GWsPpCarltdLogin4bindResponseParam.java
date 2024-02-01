package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpCarltdLogin4bindResponseParam extends BLResponseBase implements Serializable {
    public WsPpCarltdLogin4bindAckData data = new WsPpCarltdLogin4bindAckData();

    public GWsPpCarltdLogin4bindResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_PP_CARLTD_LOGIN4BIND;
        this.mNetworkStatus = 0;
    }
}
