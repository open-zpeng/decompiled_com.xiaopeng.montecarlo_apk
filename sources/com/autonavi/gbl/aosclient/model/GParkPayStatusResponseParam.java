package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkPayStatusResponseParam extends BLResponseBase implements Serializable {
    public int status = 0;
    public String errorMsg = "";

    public GParkPayStatusResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_PARKPAYSTATUS;
    }
}
