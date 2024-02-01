package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GQuerybylinksRequestParam extends BLRequestBase implements Serializable {
    public String cpcode = "";
    public String sourcefrom = "";
    public long flag = 0;
    public int vehicleType = 0;
    public ArrayList<GPathsReqParam> paths = new ArrayList<>();

    public GQuerybylinksRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_TRAFFIC_DYNAMICINFO_QUERYBYLINKS;
        this.mEReqProtol = 0;
        this.mEReqMethod = 1;
    }
}
