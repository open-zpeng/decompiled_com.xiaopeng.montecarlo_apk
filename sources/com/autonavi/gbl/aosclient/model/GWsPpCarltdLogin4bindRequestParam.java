package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpCarltdLogin4bindRequestParam extends BLRequestBase implements Serializable {
    public String source = "";
    public String userid = "";
    public String auth_id = "";

    public GWsPpCarltdLogin4bindRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_PP_CARLTD_LOGIN4BIND;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
