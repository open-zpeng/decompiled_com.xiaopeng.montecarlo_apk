package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintNaviRecordRequestParam extends BLRequestBase implements Serializable {
    public int travel_type = 0;
    public long mstimestamp = 0;
    public int count = 0;
    public String card_version = "";
    public String navi_time = "";
    public String source_adcode = "";
    public String target_adcode = "";
    public String navi_dist1 = "";
    public String navi_dist2 = "";

    public GWsUserviewFootprintNaviRecordRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_NAVI_RECORD;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
