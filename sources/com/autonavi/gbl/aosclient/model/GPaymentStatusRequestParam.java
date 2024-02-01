package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GPaymentStatusRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public int product = 2;
    public int type = 1;

    public GPaymentStatusRequestParam() {
        this.mEAosRequestType = 100003;
    }
}
