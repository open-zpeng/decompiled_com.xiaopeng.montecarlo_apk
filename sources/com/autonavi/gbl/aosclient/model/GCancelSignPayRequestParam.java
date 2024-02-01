package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCancelSignPayRequestParam extends BLRequestBase implements Serializable {
    public String OrderId = "";

    public GCancelSignPayRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_CANCELSIGNPAY;
    }
}
