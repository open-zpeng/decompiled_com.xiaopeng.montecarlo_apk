package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCarLtdQuickLoginResponseParam extends BLResponseBase implements Serializable {
    public GCarLtdQuickLoginData data = new GCarLtdQuickLoginData();

    public GCarLtdQuickLoginResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_CARLTDQUICKLOGIN;
    }
}
