package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpQrcodeInnerGetRequestParam extends BLRequestBase implements Serializable {
    public String login_type = "";
    public String biz_type = "";

    public GWsPpQrcodeInnerGetRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_PP_QRCODE_INNER_GET;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
