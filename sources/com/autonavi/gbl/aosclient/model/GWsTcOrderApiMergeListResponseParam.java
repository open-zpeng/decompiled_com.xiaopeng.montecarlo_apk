package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcOrderApiMergeListResponseParam extends BLResponseBase implements Serializable {
    public WsTcOrderApiMergeListResponseData data = new WsTcOrderApiMergeListResponseData();
    public boolean success = false;

    public GWsTcOrderApiMergeListResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_ORDER_API_MERGE_LIST;
        this.mNetworkStatus = 0;
    }
}
