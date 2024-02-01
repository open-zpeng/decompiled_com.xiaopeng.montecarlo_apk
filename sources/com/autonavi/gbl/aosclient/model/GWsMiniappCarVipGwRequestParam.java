package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMiniappCarVipGwRequestParam extends BLRequestBase implements Serializable {
    public String uid = "";
    public String method = "";
    public String version = "";
    public String timestamp = "";
    public WsMiniappCarVipGwBizContent biz_content = new WsMiniappCarVipGwBizContent();

    public GWsMiniappCarVipGwRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_MINIAPP_CAR_VIP_GW;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
