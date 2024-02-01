package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpQrcodeInnerGetResponseParam extends BLResponseBase implements Serializable {
    public WsPpQrcodeInnerGetResponseData data = new WsPpQrcodeInnerGetResponseData();

    public GWsPpQrcodeInnerGetResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_PP_QRCODE_INNER_GET;
        this.mNetworkStatus = 0;
    }
}
