package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCarLtdCheckTokenRequestParam extends BLRequestBase implements Serializable {
    public String source = "";
    public String token = "";
    public String identify = "";
    public String deviceCode = "";
    public String env = "";
    public int auth_only = 0;

    public GCarLtdCheckTokenRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_CARLTDCHECKTOKEN;
    }
}
