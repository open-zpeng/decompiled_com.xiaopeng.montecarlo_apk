package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTcFuelGetwaitingpayordersResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<String> data = new ArrayList<>();

    public GWsTcFuelGetwaitingpayordersResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_GETWAITINGPAYORDERS;
        this.mNetworkStatus = 0;
    }
}
