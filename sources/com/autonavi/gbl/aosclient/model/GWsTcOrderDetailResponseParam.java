package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcOrderDetailResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String message = "";
    public String timestamp = "";
    public String version = "";
    public WsTcOrderDetailData data = new WsTcOrderDetailData();

    public GWsTcOrderDetailResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_ORDER_DETAIL;
        this.mNetworkStatus = 0;
    }
}
