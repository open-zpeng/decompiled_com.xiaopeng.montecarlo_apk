package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsIcsLifeUserCouponListResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String timestamp = "";
    public String version = "";
    public String result = "";
    public String message = "";
    public WsIcsLifeUserCouponListResponseData data = new WsIcsLifeUserCouponListResponseData();
}
