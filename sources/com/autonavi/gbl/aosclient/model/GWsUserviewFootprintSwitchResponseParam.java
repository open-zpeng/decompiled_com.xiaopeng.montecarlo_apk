package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsUserviewFootprintSwitchResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String message = "";
    public WsUserviewFootprintSwitchData data = new WsUserviewFootprintSwitchData();

    public GWsUserviewFootprintSwitchResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_USERVIEW_FOOTPRINT_SWITCH;
        this.mNetworkStatus = 0;
    }
}
