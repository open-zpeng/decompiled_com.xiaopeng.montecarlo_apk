package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcCarServiceSubmitRequestParam extends BLRequestBase implements Serializable {
    public String uid = "";
    public WsTcCarServiceSubmitRequestData data = new WsTcCarServiceSubmitRequestData();

    public GWsTcCarServiceSubmitRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_CAR_SERVICE_SUBMIT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
