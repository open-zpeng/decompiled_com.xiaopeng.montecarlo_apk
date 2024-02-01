package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsSearchPoiAutoCmallFillOrderRequestParam extends BLRequestBase implements Serializable {
    public String oriId = "";
    public int number = 0;
    public String poiid = "";
    public String shopid = "";
    public String amapauto_version = "";
    public String outId = "";
    public String idValue = "";
    public String pageSrc = "";
    public String cancelUseCoupon = "";
    public String payChannelName = "";
    public String payOptionCode = "";
    public String payChannelExt = "";
    public String user_loc = "";
    public String ttid = "";
    public String storeId = "";
    public String cpName = "";
    public String skuid = "";
    public String activityCode = "";
    public String activityCardNo = "";
    public String scene = "";

    public GWsSearchPoiAutoCmallFillOrderRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SEARCH_POI_AUTO_CMALL_FILL_ORDER;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
