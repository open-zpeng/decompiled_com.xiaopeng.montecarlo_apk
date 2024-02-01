package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTserviceIotTripodEventResponseParam extends BLResponseBase implements Serializable {
    public String data = "";
    public ArrayList<WsTserviceIotTripodEventDataItem> data_value = new ArrayList<>();

    public GWsTserviceIotTripodEventResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_TRIPOD_EVENT;
        this.mNetworkStatus = 0;
    }
}
