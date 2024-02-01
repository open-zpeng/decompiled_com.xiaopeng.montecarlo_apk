package com.autonavi.gbl.aosclient.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GWsTserviceIotDeviceListResponseParam extends BLResponseBase implements Serializable {
    public ArrayList<WsTserviceIotDeviceListDataItem> data = new ArrayList<>();

    public GWsTserviceIotDeviceListResponseParam() {
        this.mEAosRequestType = EGAOSREQUESTTYPE.AOS_REQTYPE_TS_WS_TSERVICE_IOT_DEVICE_LIST;
        this.mNetworkStatus = 0;
    }
}
