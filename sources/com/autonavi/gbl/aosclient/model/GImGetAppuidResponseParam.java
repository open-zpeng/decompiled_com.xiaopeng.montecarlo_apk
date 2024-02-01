package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GImGetAppuidResponseParam extends BLResponseBase implements Serializable {
    public WsImGetAppuidData data = new WsImGetAppuidData();

    public GImGetAppuidResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_IM_GET_APPUID;
        this.mNetworkStatus = 0;
    }
}
