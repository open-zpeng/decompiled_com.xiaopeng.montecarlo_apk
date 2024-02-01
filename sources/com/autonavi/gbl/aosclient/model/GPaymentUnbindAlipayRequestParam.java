package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GPaymentUnbindAlipayRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public int product = 2;

    public GPaymentUnbindAlipayRequestParam() {
        this.mEAosRequestType = 100002;
    }
}
