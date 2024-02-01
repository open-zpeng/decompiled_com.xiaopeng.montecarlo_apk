package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkPayStatusRequestParam extends BLRequestBase implements Serializable {
    public String OrderId = "";
    public String AmapOrderId = "";

    public GParkPayStatusRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_PARKPAYSTATUS;
    }
}
