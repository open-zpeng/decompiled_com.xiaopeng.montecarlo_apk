package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCarLtdCheckTokenResponseParam extends BLResponseBase implements Serializable {
    public int isAmap = 0;
    public GUserProfile userProfile = new GUserProfile();
    public String mobile = "";
    public String auth_id = "";

    public GCarLtdCheckTokenResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_CARLTDCHECKTOKEN;
    }
}
