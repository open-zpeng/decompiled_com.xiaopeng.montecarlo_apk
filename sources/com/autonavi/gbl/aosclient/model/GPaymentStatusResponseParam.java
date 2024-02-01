package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GPaymentStatusResponseParam extends BLResponseBase implements Serializable {
    public int status = 0;

    public GPaymentStatusResponseParam() {
        this.mEAosRequestType = 100003;
    }
}
