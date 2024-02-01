package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpAutoWeixinQrcodeResponseParam extends BLResponseBase implements Serializable {
    public String imgStr = "";
    public String qrcodeId = "";

    public GWsPpAutoWeixinQrcodeResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_WSPPAUTOWEIXINQRCODE;
    }
}
