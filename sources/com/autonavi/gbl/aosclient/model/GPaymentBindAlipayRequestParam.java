package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GPaymentBindAlipayRequestParam extends BLRequestBase implements Serializable {
    public String tid = "";
    public int product = 2;
    public int repType = 1;

    public GPaymentBindAlipayRequestParam() {
        this.mEAosRequestType = 100001;
    }
}
