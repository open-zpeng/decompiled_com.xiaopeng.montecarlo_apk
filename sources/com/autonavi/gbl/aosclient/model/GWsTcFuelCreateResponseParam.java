package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GWsTcFuelCreateResponseParam extends BLResponseBase implements Serializable {
    public int code = 0;
    public String timestamp = "";
    public String message = "";
    public String version = "";
    public WsTcFuelCreateData data = new WsTcFuelCreateData();
    public boolean success = false;

    public GWsTcFuelCreateResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_CREATE;
        this.mNetworkStatus = 0;
    }
}
