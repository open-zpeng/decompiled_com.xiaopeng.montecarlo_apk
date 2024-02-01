package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcKoubeiOrderSubmitResponseParam extends BLResponseBase implements Serializable {
    public WsTcKoubeiOrderSubmitResponseData data = new WsTcKoubeiOrderSubmitResponseData();

    public GWsTcKoubeiOrderSubmitResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_KOUBEI_ORDER_SUBMIT;
        this.mNetworkStatus = 0;
    }
}
