package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTrafficEventDetailRequestParam extends BLRequestBase implements Serializable {
    public String eventid = "";

    public GTrafficEventDetailRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_TRAFFICEVENTDETAIL;
    }
}
