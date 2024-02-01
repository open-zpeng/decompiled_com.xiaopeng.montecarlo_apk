package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTserviceInternalLinkCarGetResponseParam extends BLResponseBase implements Serializable {
    public WsTserviceInternalLinkCarGetData data = new WsTserviceInternalLinkCarGetData();

    public GWsTserviceInternalLinkCarGetResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TSERVICE_INTERNAL_LINK_CAR_GET;
        this.mNetworkStatus = 0;
    }
}
