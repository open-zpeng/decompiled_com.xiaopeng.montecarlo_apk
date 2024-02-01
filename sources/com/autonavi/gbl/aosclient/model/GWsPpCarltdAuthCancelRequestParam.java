package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpCarltdAuthCancelRequestParam extends BLRequestBase implements Serializable {
    public String source = "";
    public String auth_id = "";

    public GWsPpCarltdAuthCancelRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_PP_CARLTD_AUTH_CANCEL;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
