package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintSummaryRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public String adcode = "";
    public String scene = "";
    public String card_version = "";

    public GWsUserviewFootprintSummaryRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_SUMMARY;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
