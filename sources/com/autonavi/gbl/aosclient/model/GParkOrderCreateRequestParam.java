package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkOrderCreateRequestParam extends BLRequestBase implements Serializable {
    public String OrderId = "";
    public String LicensePlate = "";
    public int Signpay = 1;

    public GParkOrderCreateRequestParam() {
        this.mEAosRequestType = 200011;
    }
}
