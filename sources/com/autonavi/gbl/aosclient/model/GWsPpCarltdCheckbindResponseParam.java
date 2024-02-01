package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsPpCarltdCheckbindResponseParam extends BLResponseBase implements Serializable {
    public int has_bind = 0;

    public GWsPpCarltdCheckbindResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_WSPPCARLTDCHECKBIND;
    }
}
