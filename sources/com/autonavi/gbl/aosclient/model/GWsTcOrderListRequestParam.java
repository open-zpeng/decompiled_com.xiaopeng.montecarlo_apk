package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcOrderListRequestParam extends BLRequestBase implements Serializable {
    public String gw_userid = "";
    public int bizType = 0;
    public int status = 0;
    public int pageNum = 0;
    public int pageSize = 0;
    public String ajxVersion = "";
    public long curPageMaxTs = 0;

    public GWsTcOrderListRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_ORDER_LIST;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
