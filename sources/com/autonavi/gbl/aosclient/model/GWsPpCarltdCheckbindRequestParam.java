package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpCarltdCheckbindRequestParam extends BLRequestBase implements Serializable {
    public String source = "";
    public String identify = "";

    public GWsPpCarltdCheckbindRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_WSPPCARLTDCHECKBIND;
    }
}
