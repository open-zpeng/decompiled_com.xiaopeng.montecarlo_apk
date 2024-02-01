package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GAutoInitRequestParam extends BLRequestBase implements Serializable {
    public String dic = "";
    public String dip = "";

    public GAutoInitRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_AUTOINIT;
    }
}
