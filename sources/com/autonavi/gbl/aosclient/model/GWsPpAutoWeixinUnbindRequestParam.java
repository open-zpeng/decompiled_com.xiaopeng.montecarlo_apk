package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAutoWeixinUnbindRequestParam extends BLRequestBase implements Serializable {
    public int product = 1;

    public GWsPpAutoWeixinUnbindRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_WSPPAUTOWEIXINUNBIND;
    }
}
