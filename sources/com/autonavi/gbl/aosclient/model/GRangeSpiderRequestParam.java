package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GRangeSpiderRequestParam extends BLRequestBase implements Serializable {
    public GRangeSpiderReq rangespider = new GRangeSpiderReq();

    public GRangeSpiderRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_RANGESPIDER;
    }
}
