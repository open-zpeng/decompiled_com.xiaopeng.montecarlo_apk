package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintNaviDeleteRequestParam extends BLRequestBase implements Serializable {
    public int travel_type = 0;
    public String navi_id = "";

    public GWsUserviewFootprintNaviDeleteRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_NAVI_DELETE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
