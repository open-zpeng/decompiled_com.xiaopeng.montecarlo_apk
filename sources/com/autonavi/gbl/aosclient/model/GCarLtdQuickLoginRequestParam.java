package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCarLtdQuickLoginRequestParam extends BLRequestBase implements Serializable {
    public String source = "";
    public String authId = "";

    public GCarLtdQuickLoginRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_CARLTDQUICKLOGIN;
    }
}
