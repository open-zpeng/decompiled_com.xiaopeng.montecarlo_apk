package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcAlscOrderCancelRequestParam extends BLRequestBase implements Serializable {
    public WsTcAlscOrderCancelRequestData data = new WsTcAlscOrderCancelRequestData();

    public GWsTcAlscOrderCancelRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_ALSC_ORDER_CANCEL;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
