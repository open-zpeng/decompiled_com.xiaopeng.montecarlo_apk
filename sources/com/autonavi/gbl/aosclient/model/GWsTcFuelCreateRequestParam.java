package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTcFuelCreateRequestParam extends BLRequestBase implements Serializable {
    public int bizType = 0;
    public WsTcFuelCreateOrder order = new WsTcFuelCreateOrder();
    public WsTcFuelCreateOrderExt orderExt = new WsTcFuelCreateOrderExt();
    public WsTcFuelCreateUserInfo userInfo = new WsTcFuelCreateUserInfo();
    public ArrayList<WsTcFuelCreateCouponVo> couponInfo = new ArrayList<>();
    public String ajxVersion = "";
    public String gw_userid = "";
    public int payChannel = 0;
    public String payAgreement = "";
    public String phone = "";

    public GWsTcFuelCreateRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_CREATE;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
