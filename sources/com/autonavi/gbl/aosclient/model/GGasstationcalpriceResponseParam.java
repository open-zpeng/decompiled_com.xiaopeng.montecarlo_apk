package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GGasstationcalpriceResponseParam extends BLResponseBase implements Serializable {
    public WsShieldSearchGasstationCalPriceResponseData data = new WsShieldSearchGasstationCalPriceResponseData();

    public GGasstationcalpriceResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_GASSTATION_CAL_PRICE;
        this.mNetworkStatus = 0;
    }
}
