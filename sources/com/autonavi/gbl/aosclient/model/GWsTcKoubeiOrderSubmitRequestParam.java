package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcKoubeiOrderSubmitRequestParam extends BLRequestBase implements Serializable {
    public WsTcKoubeiOrderSubmitRequestData data = new WsTcKoubeiOrderSubmitRequestData();

    public GWsTcKoubeiOrderSubmitRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_KOUBEI_ORDER_SUBMIT;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
