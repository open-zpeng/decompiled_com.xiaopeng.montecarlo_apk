package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GCarLtdUnbindRequestParam extends BLRequestBase implements Serializable {
    public String source = "";
    public String auth_id = "";
    public String device_code = "";

    public GCarLtdUnbindRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_PASSPORT_CARLTDUNBIND;
    }
}
