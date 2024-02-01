package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCarServiceOrderCancelRequestParam extends BLRequestBase implements Serializable {
    public WsTcCarServiceOrderCancelRequestData data = new WsTcCarServiceOrderCancelRequestData();

    public GWsTcCarServiceOrderCancelRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_CAR_SERVICE_ORDER_CANCEL;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
