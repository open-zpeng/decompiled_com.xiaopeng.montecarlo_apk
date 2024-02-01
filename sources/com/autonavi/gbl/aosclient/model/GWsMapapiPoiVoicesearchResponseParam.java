package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsMapapiPoiVoicesearchResponseParam extends BLResponseBase implements Serializable {
    public String keywords = "";
    public GVoiceResult voiceResult = new GVoiceResult();

    public GWsMapapiPoiVoicesearchResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WSMAPAPIPOIVOICESEARCH;
    }
}
