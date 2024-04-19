package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCouponrecvlistResponseParam extends BLResponseBase implements Serializable {
    public String code = "";
    public WsIcsLifeCouponRecvListResponseData data = new WsIcsLifeCouponRecvListResponseData();
    public String message = "";
    public boolean result = false;
    public String timestamp = "";
    public String version = "";
}
