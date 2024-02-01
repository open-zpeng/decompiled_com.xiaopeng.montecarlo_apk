package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GGasstationcalpriceRequestParam extends BLRequestBase implements Serializable {
    public String poiid = "";
    public String oil_type = "";
    public String gun_num = "";
    public String input_price = "";
    public String phone = "";
    public String from = "";
    public String type = "";
    public double discount_money = 0.0d;
    public String activityCardNo = "";
    public String ajxVersion = "";
    public String uid = "";

    public GGasstationcalpriceRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_SHIELD_SEARCH_GASSTATION_CAL_PRICE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
