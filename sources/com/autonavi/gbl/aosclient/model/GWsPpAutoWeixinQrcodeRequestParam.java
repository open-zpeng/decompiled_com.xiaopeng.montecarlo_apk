package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAutoWeixinQrcodeRequestParam extends BLRequestBase implements Serializable {
    public int product = 1;

    public GWsPpAutoWeixinQrcodeRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_WSPPAUTOWEIXINQRCODE;
    }
}
