package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GTrafficRestrictResponseParam extends BLResponseBase implements Serializable {
    public GTrafficRestrictItem Restrict = new GTrafficRestrictItem();
    public ArrayList<GTrafficRestrictItem> VecExtInfo = new ArrayList<>();

    public GTrafficRestrictResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_OSS_TRAFFICRESTRICT;
    }
}
