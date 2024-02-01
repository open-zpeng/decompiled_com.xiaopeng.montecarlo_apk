package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpQrcodeUrlTranslateRequestParam extends BLRequestBase implements Serializable {
    public String url = "";

    public GWsPpQrcodeUrlTranslateRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_WSPPQRCODEURLTRANSLATE;
    }
}
