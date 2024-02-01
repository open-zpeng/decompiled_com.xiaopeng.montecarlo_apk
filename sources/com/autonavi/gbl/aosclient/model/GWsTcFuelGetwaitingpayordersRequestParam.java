package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcFuelGetwaitingpayordersRequestParam extends BLRequestBase implements Serializable {
    public String gw_userid = "";

    public GWsTcFuelGetwaitingpayordersRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_GETWAITINGPAYORDERS;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
