package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsVaCarLogoRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public int mode = 0;

    public GWsVaCarLogoRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_VA_CAR_LOGO;
        this.mEReqMethod = 0;
    }
}
