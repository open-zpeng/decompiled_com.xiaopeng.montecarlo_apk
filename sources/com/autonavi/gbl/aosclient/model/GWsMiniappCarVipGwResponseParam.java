package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMiniappCarVipGwResponseParam extends BLResponseBase implements Serializable {
    public String traceId = "";
    public String tradeNo = "";
    public int status = 0;
    public String reason = "";

    public GWsMiniappCarVipGwResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MINIAPP_CAR_VIP_GW;
        this.mNetworkStatus = 0;
    }
}
