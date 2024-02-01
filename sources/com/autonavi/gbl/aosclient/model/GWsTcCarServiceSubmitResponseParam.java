package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCarServiceSubmitResponseParam extends BLResponseBase implements Serializable {
    public WsTcCarServiceSubmitResponseData data = new WsTcCarServiceSubmitResponseData();

    public GWsTcCarServiceSubmitResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_CAR_SERVICE_SUBMIT;
        this.mNetworkStatus = 0;
    }
}
