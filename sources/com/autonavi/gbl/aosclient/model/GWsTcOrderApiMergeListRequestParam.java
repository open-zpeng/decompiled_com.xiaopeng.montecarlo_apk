package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcOrderApiMergeListRequestParam extends BLRequestBase implements Serializable {
    public WsTcOrderApiMergeListRequestData data = new WsTcOrderApiMergeListRequestData();

    public GWsTcOrderApiMergeListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_ORDER_API_MERGE_LIST;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
