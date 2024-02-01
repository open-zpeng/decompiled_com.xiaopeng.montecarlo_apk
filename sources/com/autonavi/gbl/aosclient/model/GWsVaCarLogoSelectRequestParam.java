package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsVaCarLogoSelectRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public String logo_id = "";
    public int mode = 0;

    public GWsVaCarLogoSelectRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_WS_VA_CAR_LOGO_SELECT;
        this.mEReqMethod = 1;
    }
}
