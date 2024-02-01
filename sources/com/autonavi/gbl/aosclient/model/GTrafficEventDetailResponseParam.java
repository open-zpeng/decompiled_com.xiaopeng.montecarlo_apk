package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GTrafficEventDetailResponseParam extends BLResponseBase implements Serializable {
    public GTraEventDetail EventData = new GTraEventDetail();

    public GTrafficEventDetailResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_SNS_TRAFFICEVENTDETAIL;
    }
}
