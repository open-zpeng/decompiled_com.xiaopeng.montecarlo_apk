package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTcFuelCancelRequestParam extends BLRequestBase implements Serializable {
    public ArrayList<String> amapOrderIds = new ArrayList<>();
    public String gw_userid = "";

    public GWsTcFuelCancelRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_CANCEL;
        this.mEReqProtol = 1;
        this.mEReqMethod = 1;
    }
}
