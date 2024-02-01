package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintSwitchRequestParam extends BLRequestBase implements Serializable {
    public String strSwitch = "";
    public double lon = 0.0d;
    public double lat = 0.0d;
    public String adcode = "";
    public int tag = 0;

    public GWsUserviewFootprintSwitchRequestParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_SWITCH;
        this.mEReqProtol = 1;
        this.mEReqMethod = 0;
    }
}
