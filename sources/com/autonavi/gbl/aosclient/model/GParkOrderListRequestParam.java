package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkOrderListRequestParam extends BLRequestBase implements Serializable {
    public String LicensePlate = "";
    public int PageNo = 1;
    public int PageSize = 20;

    public GParkOrderListRequestParam() {
        this.mEAosRequestType = 200009;
    }
}
