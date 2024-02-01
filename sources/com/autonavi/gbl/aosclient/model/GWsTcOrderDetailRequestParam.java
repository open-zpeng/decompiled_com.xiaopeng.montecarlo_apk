package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcOrderDetailRequestParam extends BLRequestBase implements Serializable {
    public String data = "";
    public String amapOrderId = "";
    public String bizType = "";
    public String uid = "";
    public String phone = "";

    public GWsTcOrderDetailRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_ORDER_DETAIL;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
