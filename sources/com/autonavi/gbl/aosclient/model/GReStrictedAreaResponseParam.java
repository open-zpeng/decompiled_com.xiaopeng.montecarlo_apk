package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GReStrictedAreaResponseParam extends BLResponseBase implements Serializable {
    public GReStrictedAreaDataRes data = new GReStrictedAreaDataRes();

    public GReStrictedAreaResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_RESTRICTEDAREA;
    }
}
