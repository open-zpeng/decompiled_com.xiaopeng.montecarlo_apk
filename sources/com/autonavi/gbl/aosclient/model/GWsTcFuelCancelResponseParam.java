package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTcFuelCancelResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<String> data = new ArrayList<>();

    public GWsTcFuelCancelResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_M5_WS_TC_FUEL_CANCEL;
        this.mNetworkStatus = 0;
    }
}
