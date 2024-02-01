package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GParkOrderDetailRequestParam extends BLRequestBase implements Serializable {
    public String OrderId = "";

    public GParkOrderDetailRequestParam() {
        this.mEAosRequestType = 200010;
    }
}
